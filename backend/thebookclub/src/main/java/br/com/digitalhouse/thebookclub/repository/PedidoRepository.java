package br.com.digitalhouse.thebookclub.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digitalhouse.thebookclub.enums.FormaEnvio;
import br.com.digitalhouse.thebookclub.enums.StatusPedido;
import br.com.digitalhouse.thebookclub.enums.TipoPagamento;
import br.com.digitalhouse.thebookclub.modelo.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // public List<Pedido> findAllByLivrosContainingIgnoreCase(PedidoLivro livros);

    public Optional<Pedido> findByPedidoId(long pedidoId);

    public List<Pedido> findAllByTipoPagamento(TipoPagamento pagamento);

    public List<Pedido> findAllByFormaEnvio(FormaEnvio formaEnvio);
 
    public List<Pedido> findAllByStatus(StatusPedido formaEnvio);
}
