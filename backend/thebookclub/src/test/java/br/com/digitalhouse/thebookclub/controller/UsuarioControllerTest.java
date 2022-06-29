package br.com.digitalhouse.thebookclub.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
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
		// Aqui fica a criação dos objetos "mock", ou seja, os objetos que irão ser
		// usados no teste. Os valores em si são irrelevantes, desde que sigam
		// as regras de validações
		Usuario usuario = new Usuario(
				"Leticia",						// Nome
				"Toffoli",						// Sobrenome
				"492.827.858-10",				// CPF
				"letoffoli",					// Username
				"le.toffoli@gmail.com",			// Email
				"leticia1234",					// Senha
				"2002-09-09",					// Data de nascimento
				"Rua Botucatu",					// Rua
				740,							// Número
				"Vila Clementino",				// Bairro
				"07122-220",					// CEP
				"prédio"						// Complemento
		);
		
		// Criação de um HttpEntity com o Usuario como o corpo da requisição
		HttpEntity<Usuario> requisicao = new HttpEntity<Usuario>(usuario);
		
		// Usa-se o testRestTemplate como cliente HTTP
		ResponseEntity<Usuario> resposta = testRestTemplate
				// Aqui deve passar o endpoint e o método utilizado, juntamente da requisição
				// e do tipo do retorno, no caso é o Usuario
				.exchange("/usuarios/cadastrar",HttpMethod.POST,requisicao,Usuario.class);
		
		// As assertivas do teste vão aqui
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
		// Aqui fica a criação dos objetos "mock", ou seja, os objetos que irão ser
		// usados no teste. Os valores em si são irrelevantes, desde que sigam
		// as regras de validações
		Usuario usuario = new Usuario(
				"Gabriel",						// Nome
				"Soares",						// Sobrenome
				"137.467.467-18",				// CPF
				"ghsoares",						// Username
				"ghsoares99795@gmail.com",		// Email
				"Senha123",						// Senha
				"2002-11-25",					// Data de nascimento
				"Rua Pinheirinho D'Água",		// Rua
				313,							// Número
				"Parque Pan Americano",			// Bairro
				"02675-031",					// CEP
				"Casa 2"						// Complemento
		);
		
		// Para poder salvar corretamente, deve-se usar o service, não o repository,
		// assim ele salva com a senha encriptografada corretamente.
		// Como ele retorna um optional, usa-se o orElseThrow para poder dar erro
		// no teste em si, caso der algo de errado no salvamento
		usuarioService.cadastrarUsuario(usuario).orElseThrow(null);
		
		// Usa-se o testRestTemplate como cliente HTTP
		ResponseEntity<Usuario> resposta = testRestTemplate
				// Aqui deve passar as credenciais do usuário em questão,
				// ou as credenciais do usuário admin root ("root", "root"),
				// ou pode remover essa linha para passar um requisição sem autenticação
				// (depende se a requisição precisa de autenticação e se pode ser um usuário ou deve ser admin)
				.withBasicAuth("root", "root")
				// Aqui deve passar o endpoint e o método utilizado, juntamente da requisição
				// e do tipo do retorno, no caso é o Usuario
				.exchange("/usuarios/email/ghsoares99795@gmail.com", HttpMethod.GET, null, Usuario.class);
		
		// As assertivas do teste vão aqui
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
		// Aqui fica a criação dos objetos "mock", ou seja, os objetos que irão ser
		// usados no teste. Os valores em si são irrelevantes, desde que sigam
		// as regras de validações
		Usuario usuario1 = new Usuario(
			"Noah",							// Nome
			"Thales",						// Sobrenome
			"292.247.156-05",				// CPF
			"noahthales",					// Username
			"noah-nunes86@vemter.com.br",	// Email
			"Senha123",						// Senha
			"1995-11-06",					// Data de nascimento
			"Rua E-5",						// Rua
			869,							// Número
			"Jardim Nossa Senhora Aparecida",// Bairro
			"78090-668",					// CEP
			""								// Complemento
		);
		
		Usuario usuario2 = new Usuario(
			"Heloisa",						// Nome
			"Novaes",						// Sobrenome
			"656.242.296-58",				// CPF
			"novaeshel",					// Username
			"heloisa_eloa_novaes@cntbrasil.com.br",// Email
			"Senha123",						// Senha
			"1949-01-14",					// Data de nascimento
			"Rua Evaristo da Veiga",		// Rua
			536,							// Número
			"Virgem Santa",					// Bairro
			"27948-349",					// CEP
			""								// Complemento
		);
		
		// Para poder salvar corretamente, deve-se usar o service, não o repository,
		// assim ele salva com a senha encriptografada corretamente.
		// Como ele retorna um optional, usa-se o orElseThrow para poder dar erro
		// no teste em si, caso der algo de errado no salvamento
		usuario1 = usuarioService.cadastrarUsuario(usuario1).orElseThrow(null);
		usuario2 = usuarioService.cadastrarUsuario(usuario2).orElseThrow(null);
		
		// Aqui está mudando o email do usuário 2 para o email exato do usuário 1,
		// para simular a mudança de email para o email de outro usuário
		usuario2.setEmail(usuario1.getEmail());
		
		// Criação de um HttpEntity com o Usuario como o corpo da requisição
		HttpEntity<Usuario> requisicao = new HttpEntity<Usuario>(usuario2);
		
		// Usa-se o testRestTemplate como cliente HTTP
		ResponseEntity<Usuario> resposta = testRestTemplate
				// Aqui deve passar as credenciais do usuário em questão,
				// ou as credenciais do usuário admin root ("root", "root"),
				// ou pode remover essa linha para passar um requisição sem autenticação
				// (depende se a requisição precisa de autenticação e se pode ser um usuário ou deve ser admin)
				.withBasicAuth("novaeshel", "Senha123")	
				// Aqui deve passar o endpoint e o método utilizado, juntamente da requisição
				// e do tipo do retorno, no caso é o Usuario
				.exchange("/usuarios/atualizar", HttpMethod.PUT, requisicao, Usuario.class);
		
		// As assertivas do teste vão aqui
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
