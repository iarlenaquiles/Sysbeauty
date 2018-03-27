package com.beleza.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Qualificacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(fetch = FetchType.EAGER)
	private Agendamento agendamento;

	private int nota;

	private String comentario;

	private StatusQualificacao status;

	public Qualificacao(Integer id, Agendamento agendamento, String comentario, int nota, StatusQualificacao status) {
		this.id = id;
		this.agendamento = agendamento;
		this.comentario = comentario;
		this.nota = nota;
		this.status = status;
	}

	public Qualificacao() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public StatusQualificacao getStatus() {
		return status;
	}

	public void setStatus(StatusQualificacao status) {
		this.status = status;
	}

}
