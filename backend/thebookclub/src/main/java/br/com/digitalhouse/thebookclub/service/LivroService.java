package br.com.digitalhouse.thebookclub.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.digitalhouse.thebookclub.modelo.Livro;
import br.com.digitalhouse.thebookclub.repository.LivroRepository;

@Service
public class LivroService {
	@Autowired
	private LivroRepository livroRepository;
	
	public Optional<Livro> cadastrar(Livro livro) {
		if (livroRepository.findByIsbn(livro.getIsbn()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Livro já existe!", null);
		}
		return Optional.of(livroRepository.save(livro));
	}
	
	public Optional<Livro> atualizar(Livro livro) {
		if (livroRepository.findById(livro.getLivroId()).isPresent()) {
			Optional<Livro> buscaLivro = livroRepository.findByIsbn(livro.getIsbn());
			
			if (buscaLivro.isPresent() && buscaLivro.get().getLivroId() != livro.getLivroId()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Livro já existe!", null);
			}
			return Optional.of(livroRepository.save(livro));
		}
		return Optional.empty();
	}
	
	public Optional<Livro> deletar(Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		if (livro.isPresent()) {
			livroRepository.deleteById(id);
			return livro;
		}
		return Optional.empty();
	}
}
