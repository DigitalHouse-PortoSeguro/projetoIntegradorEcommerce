package br.com.digitalhouse.thebookclub.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

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
import br.com.digitalhouse.thebookclub.service.UsuarioService;




@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsuarioControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private UsuarioService usuarioService;
	
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
	public void deveCriarUmUsuario()throws java.text.ParseException
	{
		Usuario usuario = new Usuario();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		usuario.setNome("Leticia");
		usuario.setSobrenome("Toffoli");
		usuario.setCpf("492.827.858-10");
		usuario.setUsername("letoffoli");
		usuario.setEmail("le.toffoli@gmail.com");
		usuario.setSenha("leticia1234");
		Date date = formatter.parse("2002-09-09");
		usuario.setDataNascimento(date);
		usuario.setRua("Rua Botucatu");
		usuario.setNumero(740);
		usuario.setBairro("Vila Clementino");
		usuario.setCep("07122-220");
		usuario.setComplemento("prédio");
		
		
		
		HttpEntity<Usuario> requisicao = new HttpEntity<Usuario>(usuario);
		ResponseEntity<Usuario> resposta = testRestTemplate
				.exchange("/usuarios/cadastrar",HttpMethod.POST,requisicao,Usuario.class);
		
		assertEquals(HttpStatus.CREATED,resposta.getStatusCode());
		assertEquals(requisicao.getBody().getNome(),resposta.getBody().getNome());
		assertEquals(requisicao.getBody().getUsername(),resposta.getBody().getUsername());
		assertEquals(requisicao.getBody().getCpf(),resposta.getBody().getCpf());
		
		
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
