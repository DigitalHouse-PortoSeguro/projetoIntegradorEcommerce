package br.com.digitalhouse.thebookclub.modelo;

import java.util.Date;

public class UsuarioLogin {
	private Long usuarioId;
	private String cpf;
	private String nome;
	private String sobrenome;
	private String username;
	private String email;
	private Date dataNascimento;
	private String preferencias;
	private String cep;
	private String bairro;
	private String rua;
	private Integer numero;
	private String complemento;
	
	/*
	 *  Token é a propriedade específica do UsuarioLogin,
	 *  serve para manter a autenticação com o back-end
	 */
	private String token;

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

	public String getToken() {
		return token;
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

	public void setToken(String token) {
		this.token = token;
	}
}
