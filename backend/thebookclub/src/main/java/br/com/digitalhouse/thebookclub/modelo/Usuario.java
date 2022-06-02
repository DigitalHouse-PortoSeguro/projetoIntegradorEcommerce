package br.com.digitalhouse.thebookclub.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUsuario;
	
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Size(min=2,max=100)
	private String nome;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Size(min=2,max=100)
	private String sobrenome;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Pattern(regexp = "\\d{3}.\\d{3}.\\d{3}-\\d{2}", message="CPF Deve ser Preenchido no Formato XXX.XXX.XXX-XX")
	private String cpf;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Size(min=5,max=20)
	private String username;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Size(min=6,max=15)
	private String senha;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Min(value=2, message="Este Campo Deve Conter no Mínimo 2 Dígitos")
	private Integer idade;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Size(min=6,max=15)
	private String historico;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Size(min=3,max=100)
	private String endereco;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	//@Range(min=0, max=9999, message="Este Campo Deve Conter no Mínimo 2 Dígitos")
	@Max(value=9999, message="Quantidade Max: não pode ultrapassar 100 unidades")
	private Integer numero;
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Size(min=4,max=100)
	private String bairro;
	
	
	@NotNull(message="Este Campo é de Preenchimento Obrigatório e Não Pode Ser Vazio")
	@Size(min=4,max=100)
	private String complemento;
	
	
	
	
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}