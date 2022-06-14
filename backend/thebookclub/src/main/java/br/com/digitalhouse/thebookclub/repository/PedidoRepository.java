package br.com.digitalhouse.thebookclub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digitalhouse.thebookclub.enums.FormaEnvio;
import br.com.digitalhouse.thebookclub.enums.TipoPagamento;
import br.com.digitalhouse.thebookclub.modelo.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // public List<Pedido> findAllByLivrosContainingIgnoreCase(PedidoLivro livros);

    public Optional<Pedido> findByPedidoId(long pedidoId);

    public Optional<Pedido> findByTipoPagamento(TipoPagamento pagamento);

    public Optional<Pedido> findByFormaEnvio(FormaEnvio formaEnvio);
    
}
