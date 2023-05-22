package com.api.natureza.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="projetoreflorestamento")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ProjetoReflorestamento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="titulo", unique=true)
	@Size(min=2, max=50)
	private String titulo;
	
	@Column(name="descricao")
	@Size(min=2, max=100)
	private String descricao;
	
	@Column(name="data_hora_evento")
	private String dataHoraEvento;
	
	@Column(name="quant_participantes")
	private Long quantParticipantes;
	
	@ManyToOne
	@JoinColumn(name="parque_id")
	private ParqueEntity parque;

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getDataHoraEvento() {
		return dataHoraEvento;
	}

	public Long getQuantParticipantes() {
		return quantParticipantes;
	}

	public ParqueEntity getParque() {
		return parque;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setDataHoraEvento(String dataHoraEvento) {
		this.dataHoraEvento = dataHoraEvento;
	}

	public void setQuantParticipantes(Long quantParticipantes) {
		this.quantParticipantes = quantParticipantes;
	}

	public void setParque(ParqueEntity parque) {
		this.parque = parque;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataHoraEvento, descricao, id, parque, quantParticipantes, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjetoReflorestamento other = (ProjetoReflorestamento) obj;
		return Objects.equals(dataHoraEvento, other.dataHoraEvento) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(parque, other.parque)
				&& Objects.equals(quantParticipantes, other.quantParticipantes) && Objects.equals(titulo, other.titulo);
	}
	
}
