package com.projectg2.thebookclub.model;

import java.util.ArrayList;
import java.util.List;

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
	private Long id_estoque;
	
	//TODO pesquisar annotation de chave estrangeira
	private Long id_livro;
	
	@Null
	private Integer quantidade;
	
	@NotNull
	@Size(min = 10, max = 100)
	private String fornecedor;
	
	//TODO como controlar quantidades de livros no estoque?
	private List<Livro> livros = new ArrayList<>();

	//getters and setters
	public Long getId_estoque() {
		return id_estoque;
	}

	public Long getId_livro() {
		return id_livro;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	} 
	
	//class methods
	//TODO criar métodos para adicionar / remover livros do estoque
	

}
