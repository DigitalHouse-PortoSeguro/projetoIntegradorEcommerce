package br.com.digitalhouse.thebookclub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digitalhouse.thebookclub.modelo.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
	
	public List<Livro> findAllByTituloContainingIgnoreCase(String titulo);
}