package br.com.digitalhouse.thebookclub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitalhouse.thebookclub.modelo.Pedido;
import br.com.digitalhouse.thebookclub.modelo.PedidoLivro;
import br.com.digitalhouse.thebookclub.repository.PedidoLivroRepository;
import br.com.digitalhouse.thebookclub.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PedidoLivroRepository pedidoLivroRepository;
	
	public Optional<Pedido> salvar(Pedido pedido) {
		// List dos pedido livros
		// List<PedidoLivro> livros = pedido.getLivros();
		
		// Salva os livros
		// livros = pedidoLivroRepository.saveAll(livros);
		
		// Guarda os novos livros
		// pedido.setLivros(livros);
		
		return Optional.of(pedidoRepository.save(pedido));
	}
	
	public Optional<Pedido> atualizar(Pedido pedido) {
		if (pedidoRepository.findById(pedido.getPedidoId()).isPresent()) {
			// List dos pedido livros
			//List<PedidoLivro> livros = pedido.getLivros();
			
			// Salva os livros
			//livros = pedidoLivroRepository.saveAll(livros);
			
			// Guarda os novos livros
			//pedido.setLivros(livros);
			
			// Salva o pedido
			return Optional.of(pedidoRepository.save(pedido));
			
		}
		return Optional.empty();
	}
}
