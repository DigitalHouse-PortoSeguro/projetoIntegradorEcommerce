package br.com.digitalhouse.thebookclub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitalhouse.thebookclub.modelo.Pedido;
import br.com.digitalhouse.thebookclub.modelo.PedidoLivro;
import br.com.digitalhouse.thebookclub.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Optional<Pedido> cadastrar(Pedido pedido) {		
		// Pega os livros
		List<PedidoLivro> pedidoLivros = pedido.getPedidoLivros();
		
		// Para cada PedidoLivro
		for (PedidoLivro pedidoLivro : pedidoLivros) {
			// Muda a referência do peido
			pedidoLivro.setPedido(pedido);
		}
		
		// Salva o pedido
		return Optional.of(pedidoRepository.save(pedido));
	}
	
	public Optional<Pedido> atualizar(Pedido pedido) {
		if (pedidoRepository.findById(pedido.getPedidoId()).isPresent()) {
			// Pega os livros
			List<PedidoLivro> pedidoLivros = pedido.getPedidoLivros();
			
			// Para cada PedidoLivro
			for (PedidoLivro pedidoLivro : pedidoLivros) {
				// Muda a referência do peido
				pedidoLivro.setPedido(pedido);
			}
			
			// Salva o pedido
			return Optional.of(pedidoRepository.save(pedido));
		}
		return Optional.empty();
	}
	
	public Optional<Pedido> deletar(Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if (pedido.isPresent()) {
			pedidoRepository.deleteById(id);
			return pedido;
		}
		return Optional.empty();
	}
}
