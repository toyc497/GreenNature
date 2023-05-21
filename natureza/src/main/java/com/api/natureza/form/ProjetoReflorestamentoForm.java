package com.api.natureza.form;

public class ProjetoReflorestamentoForm {

	private Long id;
	private String titulo;
	private String descricao;
	private String dataHoraEvento;
	private Long quantParticipantes;
	private Long idParque;
	
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
	public Long getIdParque() {
		return idParque;
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
	public void setIdParque(Long idParque) {
		this.idParque = idParque;
	}
	
}
