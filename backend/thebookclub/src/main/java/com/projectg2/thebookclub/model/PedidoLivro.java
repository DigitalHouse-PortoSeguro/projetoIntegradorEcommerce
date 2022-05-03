package com.projectg2.thebookclub.model;

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
	
	@NotNull
	private Integer quantidade;
	
	@NotNull
	private Double precoVenda;
	
	@ManyToOne
	@JsonIgnoreProperties("tb_pedido_livro")
	private Pedido pedido;
	
	@ManyToOne
	@JsonIgnoreProperties("tb_pedido_livro")
	private Livro livro;

	public Long getPedidoLivroId() {
		return pedidoLivroId;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public Livro getLivro() {
		return livro;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPedidoLivroId(Long pedidoLivroId) {
		this.pedidoLivroId = pedidoLivroId;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}
}





