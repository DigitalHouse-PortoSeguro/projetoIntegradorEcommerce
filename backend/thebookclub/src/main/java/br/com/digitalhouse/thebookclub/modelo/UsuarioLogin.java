package br.com.digitalhouse.thebookclub.modelo;

import java.util.Date;

public class UsuarioLogin {
	private Long id_Usuario;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String username;
	private String email;
	private String senha;
	private Date dataNascimento;
	private String preferencias;
	private String rua;
	private Integer numero;
	private String bairro;
	private String cep;
	private String complemento;
	
	/*
	 *  Token é a propriedade específica do UsuarioLogin,
	 *  serve para manter a autenticação com o back-end
	 */
	private String token;

	public Long getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(Long id_Usuario) {
		this.id_Usuario = id_Usuario;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
}
