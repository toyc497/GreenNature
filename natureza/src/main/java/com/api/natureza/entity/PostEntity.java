package com.api.natureza.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="post")
public class PostEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="quant_likes")
	private Long quantLikes;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="img_name")
	private String imgName; 
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private UsuarioEntity usuario;
	
	@ManyToOne
	@JoinColumn(name="parque_id")
	private ParqueEntity parque;

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

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public ParqueEntity getParque() {
		return parque;
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

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public void setParque(ParqueEntity parque) {
		this.parque = parque;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, id, imgName, parque, quantLikes, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostEntity other = (PostEntity) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Objects.equals(imgName, other.imgName) && Objects.equals(parque, other.parque)
				&& Objects.equals(quantLikes, other.quantLikes) && Objects.equals(usuario, other.usuario);
	}
	
}
