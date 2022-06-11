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
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.digitalhouse.thebookclub.enums.StatusPedido;

@Entity
@Table(name="tb_livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long livroId;
	
	@OneToMany(mappedBy = "livro", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tb_livro")
	private List<PedidoLivro> pedidoLivros;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Size(min=2,max=100)
	private String titulo;
	
	@NotNull(message = "A data de publicação não pode ser nula")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dataPublicacao;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Size(min=2,max=200)
	private String autores;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Size(min=2,max=30)
	private String editora;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Size(min=2,max=30)
	private String categoria;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Min(value=1, message="Este Campo Deve Conter no Mínimo 1 Dígito")
	//@Max(value=5, message="Este Campo Deve Conter no Máximo 5 Dígito")
	private Integer numeroPaginas;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Size(min=8,max=13)
	private String isbn;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Digits(integer=3, fraction=2, message="Preço Possui 3 Casas Inteiras e 2 Casas Após o Ponto")
	private double preco;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Min(value=1, message="Este Campo Deve Conter no Mínimo 1 Dígito")
	//@Max(value=3, message="Este Campo Deve Conter no Máximo 3 Dígito")
	private Integer quantidadeEstoque;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Size(min=2,max=100)
	private String fornecedor;

	public Long getLivroId() {
		return livroId;
	}

	public List<PedidoLivro> getPedidoLivros() {
		return pedidoLivros;
	}

	public String getTitulo() {
		return titulo;
	}

	public Date getDataPublicacao() {
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

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public double getPreco() {
		return preco;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setLivroId(Long livroId) {
		this.livroId = livroId;
	}

	public void setPedidoLivros(List<PedidoLivro> pedidoLivros) {
		this.pedidoLivros = pedidoLivros;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDataPublicacao(Date dataPublicacao) {
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

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
}