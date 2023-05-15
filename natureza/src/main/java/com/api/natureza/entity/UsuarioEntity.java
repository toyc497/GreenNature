package com.api.natureza.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuario")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome")
	@NotBlank
	private String nome;
	
	@Column(name="email", unique=true)
	private String email;
	
	@Column(name="senha")
	@Size(min=8,max=20)
	private String senha;
	
	@Column(name="tipo_usuario")
	@NotBlank
	private String tipoUsuario;
	
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private ParqueEntity parque;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<PostEntity> posts = new ArrayList<>();

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

	public ParqueEntity getParque() {
		return parque;
	}

	public List<PostEntity> getPosts() {
		return posts;
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

	public void setParque(ParqueEntity parque) {
		this.parque = parque;
	}

	public void setPosts(List<PostEntity> posts) {
		this.posts = posts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, nome, parque, posts, senha, tipoUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioEntity other = (UsuarioEntity) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(parque, other.parque) && Objects.equals(posts, other.posts)
				&& Objects.equals(senha, other.senha) && Objects.equals(tipoUsuario, other.tipoUsuario);
	}
	
}
