package br.com.digitalhouse.thebookclub.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.digitalhouse.thebookclub.enums.FormaEnvio;
import br.com.digitalhouse.thebookclub.enums.StatusPedido;
import br.com.digitalhouse.thebookclub.enums.TipoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//Referência a tabela pedidos
@Entity
@Table(name="tb_pedido")
public class Pedido {
	
	//Numero do pedido
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pedidoId;
	
	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	//Valor total do pedido
	@NotNull
	@Size(min=2,max=10)
	private Double valor;

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	//Forma de pagamento do pedido
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoPagamento pagamento;
	
	public TipoPagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(TipoPagamento pagamento) {
		this.pagamento = pagamento;
	}
	

	//Forma de envio
	@NotNull
	@Enumerated(EnumType.STRING)
	private FormaEnvio formaEnvio;

	public FormaEnvio getFormaEnvio() {
		return formaEnvio;
	}
	
	public void setFormaEnvio(FormaEnvio formaEnvio) {
		this.formaEnvio = formaEnvio;
	}
	
	//Status
	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusPedido status;
	
	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	

	//Data em que o pedido foi realizado
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataPedido;
	
	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	
	//Data de atualização do status é mais apropriado. E not null não é aplicavel nessa entrada
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataEntrega;

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	
	//Lista de livros que foram comprados 
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tb_pedido")
	private List<PedidoLivro> livros;

	public List<PedidoLivro> getLivros() {
		return livros;
	}

	public void setLivros(List<PedidoLivro> livros) {
		this.livros = livros;
	}

}