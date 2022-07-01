package br.com.digitalhouse.thebookclub.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
import javax.validation.constraints.NotNull;

import br.com.digitalhouse.thebookclub.enums.FormaEnvio;
import br.com.digitalhouse.thebookclub.enums.StatusPedido;
import br.com.digitalhouse.thebookclub.enums.TipoPagamento;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	@NotNull(message="O valor não pode ser nulo")
	private Double valor;

	//Forma de pagamento do pedido
	@NotNull(message="O tipoPagamento não pode ser nulo")
	@Enumerated(EnumType.STRING)
	private TipoPagamento tipoPagamento;

	//Forma de envio
	@NotNull(message="A formaEnvio não pode ser nulo")
	@Enumerated(EnumType.STRING)
	private FormaEnvio formaEnvio;
	
	//Status
	@NotNull(message="O status não pode ser nulo")
	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	//Data em que o pedido foi realizado
	@NotNull(message="O dataPedido não pode ser nulo")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataPedido;
	
	//Data de previsão de entrega
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataEntrega;
	
	@ManyToOne
	@JsonIgnoreProperties("pedidos")
	private Usuario usuario;
	
	//Lista de livros que foram comprados 
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("pedido")
	private List<PedidoLivro> pedidoLivros = new ArrayList<PedidoLivro>();

	public Long getPedidoId() {
		return pedidoId;
	}

	public Double getValor() {
		return valor;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public FormaEnvio getFormaEnvio() {
		return formaEnvio;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public LocalDateTime getDataEntrega() {
		return dataEntrega;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public List<PedidoLivro> getPedidoLivros() {
		return pedidoLivros;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public void setFormaEnvio(FormaEnvio formaEnvio) {
		this.formaEnvio = formaEnvio;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public void setDataEntrega(LocalDateTime dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setPedidoLivros(List<PedidoLivro> pedidoLivros) {
		this.pedidoLivros = pedidoLivros;
	}
}