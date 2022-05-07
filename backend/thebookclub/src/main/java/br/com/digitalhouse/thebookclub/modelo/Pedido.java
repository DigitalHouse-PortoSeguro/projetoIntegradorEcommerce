package br.com.digitalhouse.thebookclub.modelo;

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

import br.com.digitalhouse.thebookclub.enums.FormaEnvio;
import br.com.digitalhouse.thebookclub.enums.StatusPedido;
import br.com.digitalhouse.thebookclub.enums.TipoPagamento;


@Entity
@Table(name="tb_pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id_Pedido;
	
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
	
	
	
	public Long getId_Pedido() {
		return Id_Pedido;
	}
	public void setId_Pedido(Long id_Pedido) {
		Id_Pedido = id_Pedido;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public TipoPagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(TipoPagamento pagamento) {
		this.pagamento = pagamento;
	}
	public FormaEnvio getFormaEnvio() {
		return formaEnvio;
	}
	public void setFormaEnvio(FormaEnvio formaEnvio) {
		this.formaEnvio = formaEnvio;
	}
	public StatusPedido getStatus() {
		return status;
	}
	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Date getDataEntraga() {
		return dataEntraga;
	}
	public void setDataEntraga(Date dataEntraga) {
		this.dataEntraga = dataEntraga;
	}	
}