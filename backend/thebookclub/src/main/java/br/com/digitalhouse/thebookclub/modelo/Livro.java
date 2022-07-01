package br.com.digitalhouse.thebookclub.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long livroId;
	
	@NotNull(message="O titulo não pode ser nulo")
	@Size(min=2,max=100, message = "O tamanho do título deve ser entre {min} e {max}")
	private String titulo;

	private String foto;
	
	@NotNull(message = "A dataPublicacao não pode ser nula")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataPublicacao;
	
	@NotNull(message="O autores não pode ser nulo")
	@Size(min=2,max=200, message = "O tamanho do autores deve ser entre {min} e {max}")
	private String autores;
	
	@NotNull(message="A editora não pode ser nula")
	@Size(min=2,max=30, message = "O tamanho da editora deve ser entre {min} e {max}")
	private String editora;
	
	@NotNull(message="A categoria não pode ser nula")
	@Size(min=2,max=30, message = "O tamanho da categoria deve ser entre {min} e {max}")
	private String categoria;
	
	@NotNull(message="A sinopse não pode ser nula")
	@Size(min=2, max=2048, message = "O tamanho da sinopse deve ser pelo menos {min}")
	private String sinopse;
	
	@NotNull(message="O numeroPaginas não pode ser nulo")
	@Min(value=1, message="O numeroPaginas deve ser pelo menos {value}")
	private Integer numeroPaginas;
	
	@NotNull(message="O isbn não pode ser nulo")
	@Size(min=8,max=13, message = "O tamanho do isbn deve ser entre {min} e {max}")
	private String isbn;
	
	@NotNull(message="O preco não pode ser nulo")
	private Double preco;
	
	@NotNull(message="O quantidadeEstoque não pode ser nulo")
	@Min(value=0, message="O quantidadeEstoque deve ser pelo menos {value}")
	private Integer quantidadeEstoque;
	
	@NotNull(message="O fornecedor não pode ser nulo")
	@Size(min=2,max=100, message = "O tamanho do fornecedor deve ser entre {min} e {max}")
	private String fornecedor;
	
	@OneToMany(mappedBy = "livro", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("livro")
	private List<PedidoLivro> pedidoLivros = new ArrayList<PedidoLivro>();

	public Long getLivroId() {
		return livroId;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public String getFoto() {
		return foto;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public String getAutores() {
		return autores;
	}

	public String getEditora() {
		return editora;
	}

	public String getCategoria() {
		return categoria;
	}
	
	public String getSinopse() {
		return sinopse;
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

	public List<PedidoLivro> getPedidoLivros() {
		return pedidoLivros;
	}

	public void setLivroId(Long livroId) {
		this.livroId = livroId;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setFoto(String foto) {
		this.foto = foto; 
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
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

	public void setPedidoLivros(List<PedidoLivro> pedidoLivros) {
		this.pedidoLivros = pedidoLivros;
	}
}