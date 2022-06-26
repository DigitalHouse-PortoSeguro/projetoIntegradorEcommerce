package br.com.digitalhouse.thebookclub.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.digitalhouse.thebookclub.modelo.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
	
	public List<Livro> findAllByTituloContainingIgnoreCase(String titulo);
	public List<Livro> findAllByCategoriaContainingIgnoreCase(String categoria);
	public Optional<Livro> findByIsbn(String isbn);
	@Query("select l.categoria from Livro l")
	public Set<String> findAllCategorias();
}