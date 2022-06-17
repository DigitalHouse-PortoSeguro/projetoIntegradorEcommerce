package br.com.digitalhouse.thebookclub.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.digitalhouse.thebookclub.modelo.Usuario;
import br.com.digitalhouse.thebookclub.repository.UsuarioRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsuarioControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start()
	{
		usuarioRepository.deleteAll();
	}
	
	@Test
	@Order(1)
	@DisplayName("Cadastrar um Usuário")
	public void deveCriarUmUsuario()
	{
		// Criação do usuario (mock)
		Usuario usuario = new Usuario(
				0L,								// Id
				"Leticia",						// Nome
				"Toffoli",						// Sobrenome
				"492.827.858-10",				// CPF
				"letoffoli",					// Username
				"le.toffoli@gmail.com",			// Email
				"leticia1234",					// Senha
				LocalDate.parse("2002-09-09"),	// Datadenascimento
				"",								// Preferências
				"Rua Botucatu",					// Rua
				740,							// Número
				"Vila Clementino",				// Bairro
				"07122-220",					// CEP
				"prédio"						// Complemento
		);
		
		// Criação da requisição HTTP
		HttpEntity<Usuario> requisicao = new HttpEntity<Usuario>(usuario);
		ResponseEntity<Usuario> resposta = testRestTemplate
				.exchange("/usuarios/cadastrar",HttpMethod.POST,requisicao,Usuario.class);
		
		assertEquals(HttpStatus.CREATED,resposta.getStatusCode());
		assertEquals(requisicao.getBody().getNome(),resposta.getBody().getNome());
		assertEquals(requisicao.getBody().getUsername(),resposta.getBody().getUsername());
		assertEquals(requisicao.getBody().getCpf(),resposta.getBody().getCpf());
	}
	
	@Test
	@Order(2)
	@DisplayName("Retornar um Usuário pelo email")
	public void deveRetornarUmUsuarioEmail()
	{
		Usuario usuario = new Usuario(
				0L,								// Id
				"Gabriel",						// Nome
				"Soares",						// Sobrenome
				"137.467.467-18",				// CPF
				"ghsoares",						// Username
				"ghsoares99795@gmail.com",		// Email
				"Senha123",						// Senha
				LocalDate.parse("2002-11-25"),	// Datadenascimento
				"",								// Preferências
				"Rua Pinheirinho D'Água",		// Rua
				313,							// Número
				"Parque Pan Americano",			// Bairro
				"02675-031",					// CEP
				"Casa 2"						// Complemento
		);
		
		usuarioRepository.save(usuario);
		
		ResponseEntity<Usuario> resposta = testRestTemplate
				.withBasicAuth("root", "root")
				.exchange("/usuarios/email/ghsoares99795@gmail.com", HttpMethod.GET, null, Usuario.class);
		
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		assertEquals(usuario.getNome(),resposta.getBody().getNome());
		assertEquals(usuario.getUsername(),resposta.getBody().getUsername());
		assertEquals(usuario.getCpf(),resposta.getBody().getCpf());
	}
	
	@Test
	@Order(3)
	@DisplayName("Não deve atualizar e duplicar email")
	public void naoDeveDuplicarEmailAtualizado()
	{
		Usuario usuario1 = new Usuario(
			0L,								// Id
			"Noah",							// Nome
			"Thales",						// Sobrenome
			"292.247.156-05",				// CPF
			"noahthales",					// Username
			"noah-nunes86@vemter.com.br",	// Email
			"Senha123",						// Senha
			LocalDate.parse("1995-11-06"),	// Datadenascimento
			"",								// Preferências
			"Rua E-5",						// Rua
			869,							// Número
			"Jardim Nossa Senhora Aparecida",// Bairro
			"78090-668",					// CEP
			""								// Complemento
		);
		
		Usuario usuario2 = new Usuario(
			0L,								// Id
			"Heloisa",						// Nome
			"Novaes",						// Sobrenome
			"656.242.296-58",				// CPF
			"novaeshel",					// Username
			"heloisa_eloa_novaes@cntbrasil.com.br",// Email
			"Senha123",						// Senha
			LocalDate.parse("1949-01-14"),	// Datadenascimento
			"",								// Preferências
			"Rua Evaristo da Veiga",		// Rua
			536,							// Número
			"Virgem Santa",					// Bairro
			"27948-349",					// CEP
			""								// Complemento
		);
		
		usuario1 = usuarioRepository.save(usuario1);
		usuario2 = usuarioRepository.save(usuario2);
		
		usuario2.setEmail(usuario1.getEmail());
		
		HttpEntity<Usuario> requisicao = new HttpEntity<Usuario>(usuario2);
		
		ResponseEntity<Usuario> resposta = testRestTemplate
				.withBasicAuth("root", "root")
				.exchange("/usuarios/atualizar", HttpMethod.PUT, requisicao, Usuario.class);
		
		assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
	}
	
	
//	@Test
//	@Order(2)
//	@DisplayName("Não deve permitir duplicação de usuário")
//	public void naoDeveDuplicarUsuario()
//	{
//		usuarioService.CadastrarUsuario(new Usuario(0L,
//				"Adriana Mucciolo","adriana_mucciolo@gmail.com","12345678","http://fotolegalAdriana.jpg"));
//		HttpEntity<Usuario> requisicao = new HttpEntity<Usuario>(new Usuario(0L,
//				"Adriana Mucciolo","adriana_mucciolo@gmail.com","12345678","http://fotolegalAdriana.jpg"));
//		ResponseEntity<Usuario> resposta = testRestTemplate
//				.exchange("/usuarios/cadastrar",HttpMethod.POST,requisicao,Usuario.class);
//		assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
//	}
	
//	@Test
//	@Order(3)
//	@DisplayName("Alterar um usuário")
//	public void deveAlterarUmUsuario()
//	{
//		Optional<Usuario> usuarioCreate = usuarioService.CadastrarUsuario(new Usuario(0L,
//				"Joyce","joyce@gmail.com","12345678","http://fotoJoyce.jpg"));
//		Usuario usuarioUpdate = new Usuario(usuarioCreate.get().getId(),
//				"Joyce Meireles","joyce_meireles@gmail.com","12345678","http://fotoJoyce.jpg");
//		HttpEntity<Usuario> requisicao = new HttpEntity<Usuario>(usuarioUpdate);
//		ResponseEntity<Usuario> resposta = testRestTemplate
//				.withBasicAuth("root", "root")
//				.exchange("/usuarios/cadastrar",HttpMethod.PUT,requisicao,Usuario.class);
//		assertEquals(HttpStatus.OK,resposta.getStatusCode());
//		assertEquals(usuarioUpdate.getNome(),resposta.getBody().getNome());
//		assertEquals(usuarioUpdate.getUsuario(),resposta.getBody().getUsuario());
//		assertEquals(usuarioUpdate.getFoto(),resposta.getBody().getFoto());
//	}
	
//	@Test
//	@Order(4)
//	@DisplayName("Listar todos os usuários")
//	public void deveMostrarTodosUsuarios()
//	{
//		usuarioService.CadastrarUsuario(new Usuario(0L,
//				"Kevim Lhouis","kevim.lhouis@gmail.com","12345678","http://fotoKevim.jpg"));
//		usuarioService.CadastrarUsuario(new Usuario(0L,
//				"Vanessa Jesus","vanessa.jesus@gmail.com","12345678","http://fotoVanessa.jpg"));
//		ResponseEntity<String> resposta = testRestTemplate
//				.withBasicAuth("root", "root")
//				.exchange("/usuarios/all", HttpMethod.GET,null,String.class);
//		assertEquals(HttpStatus.OK,resposta.getStatusCode());
//	}
}
