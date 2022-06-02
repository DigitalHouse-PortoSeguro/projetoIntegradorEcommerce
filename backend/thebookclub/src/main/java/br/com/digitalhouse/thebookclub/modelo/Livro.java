package br.com.digitalhouse.thebookclub.modelo;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLivro;
	
	
	@OneToMany(mappedBy = "livro_fk", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tb_livro")
	private List<PedidoLivro> pedidoLivro_fk = new ArrayList<>();
	
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Size(min=2,max=100)
	private String titulo;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message="DATA Deve ser Preenchido no Formato dd/MM/YYYY")
	private String dataPublicacao;
	
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
	private BigDecimal preco;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Min(value=1, message="Este Campo Deve Conter no Mínimo 1 Dígito")
	//@Max(value=3, message="Este Campo Deve Conter no Máximo 3 Dígito")
	private Integer quantidadeEstoque;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Size(min=2,max=100)
	private String fornecedor;
	
	
	
	
	
	public Long getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

	public List<PedidoLivro> getPedidoLivro_fk() {
		return pedidoLivro_fk;
	}

	public void setPedidoLivro_fk(List<PedidoLivro> pedidoLivro_fk) {
		this.pedidoLivro_fk = pedidoLivro_fk;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
}