package com.projectg2.thebookclub.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Entity
@Table(name="tb_estoque")
public class Estoque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long estoqueId;
	
	//TODO pesquisar annotation de chave estrangeira
	//private Long livroId;
	
	@Null
	private Integer quantidade;
	
	@NotNull
	@Size(min = 10, max = 100)
	private String fornecedor;
	
	/*//TODO como controlar quantidades de livros no estoque?
	@OneToMany(mappedBy = "estoque", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tb_estoque")
	private List<Livro> livros = new ArrayList<>();*/

	//getters and setters
	public Long getEstoqueId() {
		return estoqueId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setEstoqueId(Long estoqueId) {
		this.estoqueId = estoqueId;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	

	
	

}
