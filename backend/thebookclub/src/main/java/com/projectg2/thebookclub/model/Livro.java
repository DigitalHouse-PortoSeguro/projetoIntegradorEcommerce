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
@Table(name="tb_livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long livroId;
	
	@NotNull
	@Size(min=2,max=100)
	private String titulo;
	
	@NotNull
	@Size(min=2,max=100)
	private String autor;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataPublicacao;
	
	@NotNull
	@Size(min=2,max=30)
	private String editora;
	
	@NotNull
	@Size(min=2,max=30)
	private String categoria;
	
	@NotNull
	@Size(min=1,max=5)
	private Integer numeroPaginas;
	
	@NotNull
	@Size(min=10,max=13)
	private String isbn;
	
	@NotNull
	@Size(min=2,max=10)
	private Double preco;
	
	@NotNull
	@Size(min=1,max=5)
	private Integer quantidadeEstoque;
	
	@NotNull
	@Size(min=2,max=100)
	private String fornecedor;
	
	public Long getLivroId() {
		return livroId;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public String getEditora() {
		return editora;
	}

	public String getCategoria() {
		return categoria;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public Double getPreco() {
		return preco;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public List<PedidoLivro> getPedidos() {
		return pedidos;
	}

	public void setLivroId(Long livroId) {
		this.livroId = livroId;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void setPedidos(List<PedidoLivro> pedidos) {
		this.pedidos = pedidos;
	}	
}