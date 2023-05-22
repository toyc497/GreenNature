package com.api.natureza.form;

public class PostForm {

	Long id;
	Long quantLikes;
	String descricao;
	String imgName;
	Long idUsuario;
	Long idParque;
	
	public Long getId() {
		return id;
	}
	public Long getQuantLikes() {
		return quantLikes;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getImgName() {
		return imgName;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public Long getIdParque() {
		return idParque;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setQuantLikes(Long quantLikes) {
		this.quantLikes = quantLikes;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public void setIdParque(Long idParque) {
		this.idParque = idParque;
	}
	
}
