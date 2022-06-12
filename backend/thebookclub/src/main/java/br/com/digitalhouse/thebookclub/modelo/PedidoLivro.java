package br.com.digitalhouse.thebookclub.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_pedido_livro")
public class PedidoLivro {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pedidoLivroId;
	
	@NotNull(message = "A quantidade não pode ser nula")
	private Integer quantidade;
	
	@NotNull(message = "O precoVenda não pode ser nulo")
	private Double precoVenda;
	
	@ManyToOne
	@JsonIgnoreProperties("pedidoLivros")
	private Pedido pedido;
	
	@ManyToOne
	@JsonIgnoreProperties("pedidoLivros")
	private Livro livro;

	public Long getPedidoLivroId() {
		return pedidoLivroId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setPedidoLivroId(Long pedidoLivroId) {
		this.pedidoLivroId = pedidoLivroId;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
}





