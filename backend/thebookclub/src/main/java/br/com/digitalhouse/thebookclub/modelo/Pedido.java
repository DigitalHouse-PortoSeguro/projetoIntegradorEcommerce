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

@Entity
@Table(name="tb_pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPedido;
	
	
	@OneToMany(mappedBy = "pedido_fk", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tb_pedido")
	private List<PedidoLivro> pedidoLivro_fk = new ArrayList<>();
	
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Size(min=2,max=100)
	private String usuarioPedido;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Digits(integer=3, fraction=2, message="Preço Possui 3 Casas Inteiras e 2 Casas Após o Ponto")
	private BigDecimal valor;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Enumerated(EnumType.STRING)
	private StatusPedido status;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Enumerated(EnumType.STRING)
	private FormaEnvio formaEnvio;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Enumerated(EnumType.STRING)
	private TipoPagamento tipoPagamento;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message="DATA Deve ser Preenchido no Formato dd/MM/YYYY")
	private String dataPedido;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message="DATA Deve ser Preenchido no Formato dd/MM/YYYY")
	private String dataEntrega;
	
	
	
	
	
	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public List<PedidoLivro> getPedidoLivro_fk() {
		return pedidoLivro_fk;
	}

	public void setPedidoLivro_fk(List<PedidoLivro> pedidoLivro_fk) {
		this.pedidoLivro_fk = pedidoLivro_fk;
	}

	public Usuario getUsuario_fk() {
		return usuario_fk;
	}

	public void setUsuario_fk(Usuario usuario_fk) {
		this.usuario_fk = usuario_fk;
	}

	public String getUsuarioPedido() {
		return usuarioPedido;
	}

	public void setUsuarioPedido(String usuarioPedido) {
		this.usuarioPedido = usuarioPedido;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public FormaEnvio getFormaEnvio() {
		return formaEnvio;
	}

	public void setFormaEnvio(FormaEnvio formaEnvio) {
		this.formaEnvio = formaEnvio;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
}