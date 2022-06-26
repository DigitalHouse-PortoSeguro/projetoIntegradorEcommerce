package br.com.digitalhouse.thebookclub.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.digitalhouse.thebookclub.enums.TipoUsuario;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuarioId;

	@NotNull(message = "O nome não pode ser nulo")
	@Size(min = 2, max = 100, message = "O tamanho do nome deve ser entre {min} e {max}")
	private String nome;

	@NotNull(message = "O sobrenome não pode ser nulo")
	@Size(min = 2, max = 100, message = "O tamanho do sobrenome deve ser entre {min} e {max}")
	private String sobrenome;

	@NotNull(message = "O CPF não pode ser nulo")
	@Pattern(regexp = "\\d{3}.\\d{3}.\\d{3}-\\d{2}", message = "O CPF deve seguir o formato XXX.XXX.XXX-XX")
	private String cpf;

	@NotNull(message = "O username não pode ser nulo")
	@Size(min = 5, max = 20, message = "O tamanho do username deve ser entre {min} e {max}")
	private String username;

	@NotNull(message = "O email não pode ser nulo")
	@Email(regexp = "^(.+)@(.+)$", message = "O email deve seguir o formato email@exemplo.com")
	private String email;

	@NotNull(message = "A senha não pode ser nula")
	@Size(min = 6, message = "A senha deve ter pelo menos {min} caracteres")
	private String senha;

	@NotNull(message = "A data de nascimento não pode ser nula")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;

	@Nullable
	@Size(max = 255, message = "O tamanho das preferências deve ser no máximo {max}")
	private String preferencias;

	@NotNull(message = "A rua não pode ser nula")
	@Size(min = 3, max = 100, message = "O tamanho da rua deve ser entre {min} e {max}")
	private String rua;

	@NotNull(message = "O número não pode ser nulo")
	private Integer numero;

	@NotNull(message = "O bairro não pode ser nulo")
	@Size(min = 3, max = 100, message = "O tamanho do bairro deve ser entre {min} e {max}")
	private String bairro;

	@NotNull(message = "O CEP não pode ser nulo")
	@Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve seguir o formato XXXXX-XXX")
	private String cep;

	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;
	
	@Nullable
	@Size(max = 100, message = "O tamanho do complemento deve ser no máximo {max}")
	private String complemento;
	
	private String foto;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Pedido> pedidos = new ArrayList<Pedido>();

	public Usuario() {}
	
	// Construtor usado em testes
	public Usuario(String nome, String sobrenome, String cpf, String username, String email,
			String senha, String dataNascimento, String rua, Integer numero, String bairro,
			String cep, String complemento) {
		this.usuarioId = 0L;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.username = username;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = LocalDate.parse(dataNascimento);
		this.preferencias = "";
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.tipoUsuario = TipoUsuario.COMUM;
		this.complemento = complemento;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getPreferencias() {
		return preferencias;
	}

	public String getRua() {
		return rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCep() {
		return cep;
	}
	
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public String getComplemento() {
		return complemento;
	}
	
	public String getFoto() {
		return foto;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setPreferencias(String preferencias) {
		this.preferencias = preferencias;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}