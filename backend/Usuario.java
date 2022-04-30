package src.main.java.com.projectg2.thebookclub;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(uniqueConstraints = @UniqueConstraint ( columnNames = "CPF", name="tb_usuario"))
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	
	@NotNull
	@Size(min=4,max=11)
	private String cpf;
	
	@NotNull
	@Size(min=4,max=50)
	private String nome;
	
	@NotNull
	@Size(min=4,max=50)
	private String sobrenome;
	
	@NotNull
	@Size(min=4,max=20)
	private String username;
	
	@NotNull
	@Size(min=4,max=15)
	private String senha;
	
	@NotNull
	@Size(min=4,max=50)
	private String email;
	
	@Temporal(TemporalType.DATE)
	private Date dataAniversario ;
	
	@NotNull
	@Size(min=4,max=255)
	private String preferencias;
	
	@NotNull
	@Size(min=4,max=50)
	private String cep;
	
	@NotNull
	@Size(min=4,max=50)
	private String bairro;
	
	@NotNull
	@Size(min=4,max=50)
	private String rua;
	
	private Integer numero;
	
	
	private String complemento;
	
	
	
	
	
	
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate() {
		return dataAniversario;
	}
	public void setDate(Date date) {
		this.dataAniversario = date;
	}
	public String getPreferencias() {
		return preferencias;
	}
	public void setPreferencias(String preferencias) {
		this.preferencias = preferencias;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
