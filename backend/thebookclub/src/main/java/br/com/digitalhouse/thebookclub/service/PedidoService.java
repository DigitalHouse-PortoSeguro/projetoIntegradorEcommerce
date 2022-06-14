package br.com.digitalhouse.thebookclub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.digitalhouse.thebookclub.modelo.Livro;
import br.com.digitalhouse.thebookclub.modelo.Pedido;
import br.com.digitalhouse.thebookclub.modelo.PedidoLivro;
import br.com.digitalhouse.thebookclub.repository.LivroRepository;
import br.com.digitalhouse.thebookclub.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private LivroRepository livroRepository;

	public Optional<Pedido> cadastrar(Pedido pedido) {
		// Pega os livros
		List<PedidoLivro> pedidoLivros = pedido.getPedidoLivros();

		// Para cada PedidoLivro
		for (PedidoLivro pedidoLivro : pedidoLivros) {
			// Pega o id do livro
			Long livroId = pedidoLivro.getLivro().getLivroId();

			// Pega o livro pelo id
			Optional<Livro> livro = livroRepository.findById(livroId);

			// Caso exista
			if (livro.isPresent()) {
				// Checa se a quantidade é suficiente
				if (livro.get().getQuantidadeEstoque() < pedidoLivro.getQuantidade()) {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Não existe quantidade suficiente para o pedido com o livro com id " + livroId, null);
				}
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe um livro com id " + livroId, null);
			}

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
				// Pega o id do livro
				Long livroId = pedidoLivro.getLivro().getLivroId();

				// Pega o livro pelo id
				Optional<Livro> livro = livroRepository.findById(livroId);

				// Caso exista
				if (livro.isPresent()) {
					// Checa se a quantidade é suficiente
					if (livro.get().getQuantidadeEstoque() < pedidoLivro.getQuantidade()) {
						throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
								"Não existe quantidade suficiente para o pedido com o livro com id " + livroId, null);
					}
				} else {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe um livro com id " + livroId,
							null);
				}

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
