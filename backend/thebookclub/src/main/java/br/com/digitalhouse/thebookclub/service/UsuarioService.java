package br.com.digitalhouse.thebookclub.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.digitalhouse.thebookclub.modelo.UsuarioLogin;
import br.com.digitalhouse.thebookclub.modelo.Usuario;
import br.com.digitalhouse.thebookclub.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Optional<Usuario> cadastrarUsuario(Usuario usuario) {
		if (usuarioRepository.findTopByUsernameOrEmailOrCpf(usuario.getUsername(), usuario.getEmail(), usuario.getCpf())
				.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
		}
		usuario.setSenha(criptografarSenha(usuario.getSenha()));
		return Optional.of(usuarioRepository.save(usuario));
	}

	public Optional<Usuario> atualizarUsuario(Usuario usuario) {
		if (usuarioRepository.findById(usuario.getUsuarioId()).isPresent()) {
			Optional<Usuario> buscaUsuario = usuarioRepository.findTopByUsernameOrEmailOrCpf(usuario.getUsername(),
					usuario.getEmail(), usuario.getCpf());

			if (buscaUsuario.isPresent() && (buscaUsuario.get().getUsuarioId() != usuario.getUsuarioId())) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
			}

			usuario.setSenha(criptografarSenha(usuario.getSenha()));
			return Optional.ofNullable(usuarioRepository.save(usuario));
		}
		return Optional.empty();
	}

	public Optional<UsuarioLogin> autenticarUsuario(UsuarioLogin usuarioLogin) {
		Optional<Usuario> usuario = usuarioRepository.findTopByUsernameOrEmail(usuarioLogin.getUsername(), usuarioLogin.getUsername());
		if (usuario.isPresent()) {
			if (compararSenhas(usuarioLogin.getSenha(), usuario.get().getSenha())) {
				String token = gerarBasicToken(usuarioLogin.getUsername(), usuarioLogin.getSenha());
				
				usuarioLogin.setUsuarioId(usuario.get().getUsuarioId());
				usuarioLogin.setNome(usuario.get().getNome());
				usuarioLogin.setSobrenome(usuario.get().getSobrenome());
				usuarioLogin.setCpf(usuario.get().getCpf());
				usuarioLogin.setUsername(usuario.get().getUsername());
				usuarioLogin.setEmail(usuario.get().getEmail());
				usuarioLogin.setSenha(usuario.get().getSenha());
				usuarioLogin.setDataNascimento(usuario.get().getDataNascimento());
				usuarioLogin.setPreferencias(usuario.get().getPreferencias());
				usuarioLogin.setFoto(usuario.get().getFoto());
				usuarioLogin.setRua(usuario.get().getRua());
				usuarioLogin.setNumero(usuario.get().getNumero());
				usuarioLogin.setBairro(usuario.get().getBairro());
				usuarioLogin.setCep(usuario.get().getCep());
				usuarioLogin.setTipoUsuario(usuario.get().getTipoUsuario());
				usuarioLogin.setComplemento(usuario.get().getComplemento());
				usuarioLogin.setToken(token);

				return Optional.of(usuarioLogin);
			}
		}
		return Optional.empty();
	}

	public Optional<Usuario> deletar(Long id) {
		Optional<Usuario> user = usuarioRepository.findById(id);
		if (user.isPresent()) {
			usuarioRepository.deleteById(id);
			return user;
		}
		return Optional.empty();
	}

	// métodos auxiliares da classe:
	private String criptografarSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senha);

	}

	private boolean compararSenhas(String senhaDigitada, String senhaBanco) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(senhaDigitada, senhaBanco);
	}

	private String gerarBasicToken(String usuario, String senha) {
		String token = usuario + ":" + senha;
		byte[] tokenBase64 = Base64.encodeBase64(token.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(tokenBase64);
	}

}
