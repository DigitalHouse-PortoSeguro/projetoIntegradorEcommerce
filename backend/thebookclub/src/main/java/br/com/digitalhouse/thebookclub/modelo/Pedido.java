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
import javax.persistence.ManyToOne;
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

	//Valor total do pedido
	@NotNull
	@Size(min=2,max=10)
	private Double valor;

	//Forma de pagamento do pedido
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoPagamento pagamento;

	//Forma de envio
	@NotNull
	@Enumerated(EnumType.STRING)
	private FormaEnvio formaEnvio;
	
	//Status
	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	//Data em que o pedido foi realizado
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataPedido;
	
	//Data de atualização do status é mais apropriado. E not null não é aplicavel nessa entrada
	//@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataEntrega;
	
	@ManyToOne
	@JsonIgnoreProperties("tb_pedido")
	private Usuario usuario;
	
	//Lista de livros que foram comprados 
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tb_pedido")
	private List<PedidoLivro> livros;

	public Long getPedidoId() {
		return pedidoId;
	}

	public Double getValor() {
		return valor;
	}

	public TipoPagamento getPagamento() {
		return pagamento;
	}

	public FormaEnvio getFormaEnvio() {
		return formaEnvio;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public List<PedidoLivro> getLivros() {
		return livros;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setPagamento(TipoPagamento pagamento) {
		this.pagamento = pagamento;
	}

	public void setFormaEnvio(FormaEnvio formaEnvio) {
		this.formaEnvio = formaEnvio;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setLivros(List<PedidoLivro> livros) {
		this.livros = livros;
	}
}