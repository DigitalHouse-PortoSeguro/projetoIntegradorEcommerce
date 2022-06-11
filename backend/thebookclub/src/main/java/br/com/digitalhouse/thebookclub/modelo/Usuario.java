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
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long usuarioId;
	
	@NotNull(message = "O nome não pode ser nulo")
	@Size(min=2, max=100, message = "O tamanho do nome deve ser entre {min} e {max}")
	private String nome;
	
	@NotNull(message = "O sobrenome não pode ser nulo")
	@Size(min=2, max=100, message = "O tamanho do sobrenome deve ser entre {min} e {max}")
	private String sobrenome;
	
	@NotNull(message = "O CPF não pode ser nulo")
	@Pattern(regexp = "\\d{3}.\\d{3}.\\d{3}-\\d{2}", message = "O CPF deve seguir o formato XXX.XXX.XXX-XX")
	private String cpf;
	
	@NotNull(message = "O username não pode ser nulo")
	@Size(min=5,max=20, message = "O tamanho do username deve ser entre {min} e {max}")
	private String username;
	
	@NotNull(message = "O email não pode ser nulo")
	@Email(regexp = "^(.+)@(.+)$", message = "O email deve seguir o formato email@exemplo.com")
	private String email;
	
	@NotNull(message = "A senha não pode ser nula")
	@Min(value=6, message = "A senha deve ter pelo menos {min} caracteres")
	private String senha;
	
	@NotNull(message = "A data de nascimento não pode ser nula")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Nullable
	private String preferencias;
	
	@NotNull(message = "A rua não pode ser nula")
	@Size(min=3,max=100, message = "O tamanho da rua deve ser entre {min} e {max}")
	private String rua;
	
	@NotNull(message = "O número não pode ser nulo")
	private Integer numero;
	
	@NotNull(message = "O bairro não pode ser nulo")
	@Size(min=3,max=100, message = "O tamanho do bairro deve ser entre {min} e {max}")
	private String bairro;
	
	@NotNull(message = "O CEP não pode ser nulo")
	@Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve seguir o formato XXXXX-XXX")
	private String cep;
	
	@Nullable
	@Size(min=3,max=100, message = "O tamanho do complemento deve ser entre {min} e {max}")
	private String complemento;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tb_usuario")
	private List<Pedido> pedidos;

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

	public Date getDataNascimento() {
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

	public String getComplemento() {
		return complemento;
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

	public void setDataNascimento(Date dataNascimento) {
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

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}