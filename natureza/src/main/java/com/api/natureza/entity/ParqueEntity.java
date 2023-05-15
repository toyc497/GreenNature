package com.api.natureza.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="parque")
public class ParqueEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome", unique=true)
	@Size(min=2, max=50)
	private String nome;
	
	@Column(name="localizacao")
	@NotBlank
	private String localizacao;
	
	@Column(name="funcionando")
	private boolean funcionando;
	
	@OneToOne
	@JoinColumn(name="usuario_id")
	private UsuarioEntity usuario;
	
	@OneToMany(mappedBy = "parque", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ProjetoReflorestamento> projetosReflorestamento = new ArrayList<>();
	
	@OneToMany(mappedBy = "parque", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<PostEntity> posts = new ArrayList<>();

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

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public List<ProjetoReflorestamento> getProjetosReflorestamento() {
		return projetosReflorestamento;
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

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public void setFuncionando(boolean funcionando) {
		this.funcionando = funcionando;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public void setProjetosReflorestamento(List<ProjetoReflorestamento> projetosReflorestamento) {
		this.projetosReflorestamento = projetosReflorestamento;
	}

	public void setPosts(List<PostEntity> posts) {
		this.posts = posts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(funcionando, id, localizacao, nome, posts, projetosReflorestamento, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParqueEntity other = (ParqueEntity) obj;
		return funcionando == other.funcionando && Objects.equals(id, other.id)
				&& Objects.equals(localizacao, other.localizacao) && Objects.equals(nome, other.nome)
				&& Objects.equals(posts, other.posts)
				&& Objects.equals(projetosReflorestamento, other.projetosReflorestamento)
				&& Objects.equals(usuario, other.usuario);
	}
	
}
