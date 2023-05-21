package com.api.natureza.form;

public class UsuarioForm {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String tipoUsuario;
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}
