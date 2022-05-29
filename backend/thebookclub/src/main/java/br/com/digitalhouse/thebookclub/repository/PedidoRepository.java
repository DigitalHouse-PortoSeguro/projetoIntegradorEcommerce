package br.com.digitalhouse.thebookclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digitalhouse.thebookclub.modelo.Pedido;
import br.com.digitalhouse.thebookclub.modelo.PedidoLivro;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Object findAllByLivrosContainingIgnoreCase(PedidoLivro livros);

    Object findByPedidoId(long pedidoId);

}
