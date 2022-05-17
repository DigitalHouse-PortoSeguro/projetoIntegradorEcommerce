package br.com.digitalhouse.thebookclub.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Entity
@Table(name="tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long usuarioId;
	
	@NotNull
	@Size(min=11,max=14)
	private String cpf;
	
	@NotNull
	@Size(min=2,max=100)
	private String nome;
	
	@NotNull
	@Size(min=2,max=100)
	private String sobrenome;
	
	@NotNull
	@Size(min=5,max=20)
	private String username;
	
	@NotNull
	@Size(min=8)
	private String senha;

	@NotNull
	@Size(min=10,max=40)
	private String email;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@NotNull
	@Size(min=8,max=256)
	private String preferencias;
	
	@NotNull
	@Size(min=11,max=14)
	private String cep;
	
	@NotNull
	@Size(min=10,max=100)
	private String bairro;
	
	@NotNull
	@Size(min=10,max=100)
	private String rua;
	
	@NotNull
	@Size(min=1,max=6)
	private Integer numero;
	
	@Null
	@Size(min=10,max=100)
	private String complemento;

	public Long getUsuarioId() {
		return usuarioId;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getUsername() {
		return username;
	}
	
	public String getSenha() {
		return senha;
	}

	public String getEmail() {
		return email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getPreferencias() {
		return preferencias;
	}

	public String getCep() {
		return cep;
	}

	public String getBairro() {
		return bairro;
	}

	public String getRua() {
		return rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setPreferencias(String preferencias) {
		this.preferencias = preferencias;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
