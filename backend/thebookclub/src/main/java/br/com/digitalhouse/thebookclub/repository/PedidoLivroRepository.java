package br.com.digitalhouse.thebookclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.digitalhouse.thebookclub.modelo.PedidoLivro;

@Repository 
public interface PedidoLivroRepository extends JpaRepository<PedidoLivro, Long> {

	
}
