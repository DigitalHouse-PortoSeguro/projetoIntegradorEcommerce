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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalhouse.thebookclub.modelo.Pedido;
import br.com.digitalhouse.thebookclub.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/consultar")
	public ResponseEntity<List<Pedido>> GetAll(){
		return ResponseEntity.ok(pedidoRepository.findAll());
	}
	
	@GetMapping("/consultar/{id}")
	public ResponseEntity<Pedido> GetById(@PathVariable Long id){
		return pedidoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/consultar/{usuarioPedido}")
	public ResponseEntity<List<Pedido>>GetByUsuarioPedido(@PathVariable String usuarioPedido){
		return ResponseEntity.ok(pedidoRepository.findAllByUsuarioPedidoContainingIgnoreCase(usuarioPedido));
	}
	
		@PostMapping("/cadastrar")
	public ResponseEntity<Pedido> post(@RequestBody Pedido pedido){
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoRepository.save(pedido));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Pedido> put(@RequestBody Pedido pedido){
		return ResponseEntity.status(HttpStatus.OK).body(pedidoRepository.save(pedido));
	}
	
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return pedidoRepository.findById(id).map(resp -> {
				pedidoRepository.deleteById(id);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
	
}