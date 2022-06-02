package br.com.digitalhouse.thebookclub.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_pedido_livro")
public class PedidoLivro {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPedidoLivro;
	
	
	@ManyToOne
	@JsonIgnoreProperties("tb_pedido_livro")
	private Livro livro_fk;
	
	@ManyToOne
	@JsonIgnoreProperties("tb_pedido_livro")
	private Pedido pedido_fk;
	
	
	//private Integer quantidade;
	//private Double precoVenda;
	
	
	public Long getIdPedidoLivro() {
		return idPedidoLivro;
	}

	public void setIdPedidoLivro(Long idPedidoLivro) {
		this.idPedidoLivro = idPedidoLivro;
	}

	public Livro getLivro_fk() {
		return livro_fk;
	}

	public void setLivro_fk(Livro livro_fk) {
		this.livro_fk = livro_fk;
	}

	public Pedido getPedido_fk() {
		return pedido_fk;
	}

	public void setPedido_fk(Pedido pedido_fk) {
		this.pedido_fk = pedido_fk;
	}
}