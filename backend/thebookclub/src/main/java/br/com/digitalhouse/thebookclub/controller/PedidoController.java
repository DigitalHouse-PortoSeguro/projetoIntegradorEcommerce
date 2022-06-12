package br.com.digitalhouse.thebookclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.digitalhouse.thebookclub.enums.FormaEnvio;
import br.com.digitalhouse.thebookclub.enums.TipoPagamento;
import br.com.digitalhouse.thebookclub.modelo.Pedido;
import br.com.digitalhouse.thebookclub.repository.PedidoRepository;
import br.com.digitalhouse.thebookclub.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoController {

	@Autowired
	public PedidoService pedidoService;
	
	// Linkando com o repository
	@Autowired
	private PedidoRepository pedidoRepository;

	// Retorna a lista de pedidos
	@GetMapping
	public ResponseEntity<List<Pedido>> getAll() {
		return ResponseEntity.ok(pedidoRepository.findAll());
	}
	
	// Retorna por id
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> getById(@PathVariable Long id) {
		return pedidoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Pedido> cadastrar(@RequestBody Pedido pedido) {
		return pedidoService.cadastrar(pedido)
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.badRequest().build());
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Pedido> atualizar(@RequestBody Pedido pedido) {
		return pedidoService.atualizar(pedido)
				.map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	// //Retorna pedido por valor
	// @GetMapping("pedido/{valor}")
	// public ResponseEntity<Pedido> GetById(@PathVariable double valor) {
	// return repository.findById(valor)
	// .map(resp -> ResponseEntity.ok(resp))
	// .orElse((ResponseEntity.notFound().build()));
	// }

	// Retorna pedido por meio de pagamento
	@GetMapping("/tipoPagamento/{pagamento}")
	public ResponseEntity<Pedido> getByTipoPagamento(@PathVariable TipoPagamento pagamento) {
		return pedidoRepository.findByTipoPagamento(pagamento)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	// Retorna os pedidos que contem o parametro 'formaEnvio'
	@GetMapping("/formaEnvio/{formaEnvio}")
	public ResponseEntity<Pedido> getByFormaEnvio(@PathVariable FormaEnvio formaEnvio) {
		return pedidoRepository.findByFormaEnvio(formaEnvio).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	// Retorna os pedidos que contem o parametro 'livros'
	// @GetMapping("/livros/{livros}")
	// public ResponseEntity<Pedido> getByLivros(@PathVariable PedidoLivro livros) {
	//	return repository.findAllByLivrosContainingIgnoreCase(livros).map(resp -> ResponseEntity.ok(resp))
	//			.orElse(ResponseEntity.notFound().build());
	// }
	
	// Deleta por id
	@DeleteMapping("/{id}")
	public ResponseEntity<Pedido> deletar(@PathVariable Long id) {
		return pedidoService.deletar(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

}
