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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_livro;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String categoria; //isso poderia ser um enum?
	
	@NotNull
	@Size(min = 5, max = 200)
	private String titulo;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String autor;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String editora;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dt_publicacao;
	
	@NotNull
	private Integer num_paginas;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String isbn;

	
	//getters and setters
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Date getDt_publicacao() {
		return dt_publicacao;
	}

	public void setDt_publicacao(Date dt_publicacao) {
		this.dt_publicacao = dt_publicacao;
	}

	public Integer getNum_paginas() {
		return num_paginas;
	}

	public void setNum_paginas(Integer num_paginas) {
		this.num_paginas = num_paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	

}
