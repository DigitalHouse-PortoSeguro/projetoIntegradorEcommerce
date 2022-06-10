package br.com.digitalhouse.thebookclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalhouse.thebookclub.enums.FormaEnvio;
import br.com.digitalhouse.thebookclub.enums.TipoPagamento;
import br.com.digitalhouse.thebookclub.modelo.Pedido;
import br.com.digitalhouse.thebookclub.modelo.PedidoLivro;
import br.com.digitalhouse.thebookclub.repository.PedidoRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoController {

	// Linkando com o repository
	@Autowired
	private PedidoRepository repository;

	// Retorna a lista de pedidos
	@GetMapping
	public ResponseEntity<List<Pedido>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	// Retorna pedido por id
	@GetMapping("pedido/{pedidoId}")
	public ResponseEntity<Pedido> getById(@PathVariable long pedidoId) {
		return repository.findById(pedidoId).map(resp -> ResponseEntity.ok(resp))
				.orElse((ResponseEntity.notFound().build()));
	}

	// //Retorna pedido por valor
	// @GetMapping("pedido/{valor}")
	// public ResponseEntity<Pedido> GetById(@PathVariable double valor) {
	// return repository.findById(valor)
	// .map(resp -> ResponseEntity.ok(resp))
	// .orElse((ResponseEntity.notFound().build()));
	// }

	// Retorna pedido por meio de pagamento
	@GetMapping("pedido/{pagamento}")
	public ResponseEntity<Pedido> getByTipoPagamento(@PathVariable TipoPagamento pagamento) {
		return repository.findByTipoPagamento(pagamento).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	// Retorna os pedidos que contem o parametro 'formaEnvio'
	@GetMapping("/pedido/{formaEnvio}")
	public ResponseEntity<Pedido> getByFormaEnvio(@PathVariable FormaEnvio formaEnvio) {
		return repository.findByFormaEnvio(formaEnvio).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	// Retorna os pedidos que contem o parametro 'livros'
	// @GetMapping("/livros/{livros}")
	// public ResponseEntity<Pedido> getByLivros(@PathVariable PedidoLivro livros) {
	//	return repository.findAllByLivrosContainingIgnoreCase(livros).map(resp -> ResponseEntity.ok(resp))
	//			.orElse(ResponseEntity.notFound().build());
	// }

}
