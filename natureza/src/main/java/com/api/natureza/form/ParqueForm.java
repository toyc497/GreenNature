package com.api.natureza.form;

public class ParqueForm {

	Long id;
	String nome;
	String localizacao;
	boolean funcionando;
	Long idUsuario;
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public boolean isFuncionando() {
		return funcionando;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public void setFuncionando(boolean funcionando) {
		this.funcionando = funcionando;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
