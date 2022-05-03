package com.projectg2.thebookclub.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="tb_pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pedidoId;
	
	@NotNull
	@Size(min=2,max=10)
	private Double valor;
	
	private TipoPagamento pagamento;
	
	private FormaEnvio formaEnvio;
	
	private StatusPedido status;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataPedido;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataEntraga;
	
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

	public Date getDataEntraga() {
		return dataEntraga;
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

	public void setDataEntraga(Date dataEntraga) {
		this.dataEntraga = dataEntraga;
	}

	public void setLivros(List<PedidoLivro> livros) {
		this.livros = livros;
	}
}