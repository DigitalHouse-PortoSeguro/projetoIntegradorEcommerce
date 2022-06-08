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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_Usuario;
	
	@NotNull(message = "O atributo nome é obrigatório")
	@Size(min=2,max=100)
	private String nome;
	
	@NotNull(message = "O atributo sobrenome é obrigatório")
	@Size(min=2,max=100)
	private String sobrenome;
	
	@NotNull(message = "O atributo cpf é obrigatório")
	@Pattern(regexp = "\\d{3}.\\d{3}.\\d{3}-\\d{2}", 
	message="CPF Deve ser Preenchido no Formato 000.000.000-00")
	//@Size(min=11,max=14)
	private String cpf;
	
	@NotNull(message = "O atributo username é obrigatório")
	@Size(min=5,max=20)
	private String username;
	
	@NotNull(message = "O atributo tipo é obrigatório")
	private String tipoUsuario;
	
	@NotNull(message = "O atributo email é obrigatório")
	@Email(regexp="^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",
	message="O email deve ser preenchido no formato email@email.com")
	//@Schema(example = "email@email.com")
	@Size(min=10,max=40)
	private String email;
	
	@NotNull(message = "O atributo senha é obrigatório")
	@Size(min=6,max=15)
	private String senha;
	
	@NotNull(message = "O atributo data de nascimento é obrigatório")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Nullable
	private String preferencias;
	
	@NotNull(message = "O atributo rua é obrigatório")
	@Size(min=3,max=100)
	private String rua;
	
	@NotNull(message = "O atributo número é obrigatório")
	@Size(min=1,max=6)
	private Integer numero;
	
	@NotNull(message = "O atributo bairro é obrigatório")
	@Size(min=3,max=100)
	private String bairro;
	
	@NotNull(message = "O atributo cep é obrigatório")
	@Pattern(regexp = "\\d{5}-\\d{3}", message="CEP Deve ser Preenchido no Formato 00000-000")
	@Size(min=8,max=9)
	private String cep;
	
	@Nullable
	@Size(min=3,max=100)
	private String complemento;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tb_usuario")
	private List<Pedido> pedido;

	public Long getId_Usuario() {
		return id_Usuario;
	}
	public void setId_Usuario(Long id_Usuario) {
		this.id_Usuario = id_Usuario;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getPreferencias() {
		return preferencias;
	}
	public void setPreferencias(String preferencias) {
		this.preferencias = preferencias;
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
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public List<Pedido> getPedido() {
		return pedido;
	}
}