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
		if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent()
		|| usuarioRepository.findByUsername(usuario.getUsername()).isPresent()
		|| usuarioRepository.findByCpf(usuario.getCpf()).isPresent() ) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
		}
		usuario.setSenha(criptografarSenha(usuario.getSenha()));
		return Optional.of(usuarioRepository.save(usuario));
	}
	
	public Optional<Usuario> atualizarUsuario(Usuario usuario) {
		if(usuarioRepository.findById(usuario.getUsuarioId()).isPresent()) {
			Optional<Usuario> buscaUsuario = usuarioRepository.findByEmail(usuario.getEmail());
			
			if (buscaUsuario.isPresent() && (buscaUsuario.get().getUsuarioId() != usuario.getUsuarioId())) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
			}
			usuario.setSenha(criptografarSenha(usuario.getSenha()));
			return Optional.ofNullable(usuarioRepository.save(usuario));
		}
		return Optional.empty();
	}
	
	public Optional<UsuarioLogin> autenticarUsuario(Optional<UsuarioLogin> usuarioLogin) {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioLogin.get().getEmail());
		if (usuario.isPresent()) {
			if (compararSenhas(usuarioLogin.get().getSenha(), usuario.get().getSenha())) {
				usuarioLogin.get().setId_Usuario(usuario.get().getUsuarioId());
				usuarioLogin.get().setNome(usuario.get().getNome());
				usuarioLogin.get().setSobrenome(usuario.get().getSobrenome());
				usuarioLogin.get().setCpf(usuario.get().getCpf());
				usuarioLogin.get().setUsername(usuario.get().getUsername());
				usuarioLogin.get().setTipoUsuario(usuario.get().getTipoUsuario());
				usuarioLogin.get().setEmail(usuario.get().getEmail());
				usuarioLogin.get().setSenha(usuario.get().getSenha());
				usuarioLogin.get().setDataNascimento(usuario.get().getDataNascimento());
				usuarioLogin.get().setPreferencias(usuario.get().getPreferencias());
				usuarioLogin.get().setRua(usuario.get().getRua());
				usuarioLogin.get().setNumero(usuario.get().getNumero());
				usuarioLogin.get().setBairro(usuario.get().getBairro());
				usuarioLogin.get().setCep(usuario.get().getCep());
				usuarioLogin.get().setComplemento(usuario.get().getComplemento());
				usuarioLogin.get().setToken(gerarBasicToken(usuarioLogin.get().getCpf(), usuarioLogin.get().getSenha()));
				return usuarioLogin;

			}
		}
		return Optional.empty();
	}

	
	//métodos auxiliares da classe:
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
