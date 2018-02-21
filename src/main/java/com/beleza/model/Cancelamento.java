package com.beleza.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Cancelamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	private Agendamento agenda;

	private String motivo_cancelamento;

	public Cancelamento(Integer id, Agendamento agenda, String motivo_cancelamento) {
		this.id = id;
		this.agenda = agenda;
		this.motivo_cancelamento = motivo_cancelamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Agendamento getAgenda() {
		return agenda;
	}

	public void setAgenda(Agendamento agenda) {
		this.agenda = agenda;
	}

	public String getMotivo_cancelamento() {
		return motivo_cancelamento;
	}

	public void setMotivo_cancelamento(String motivo_cancelamento) {
		this.motivo_cancelamento = motivo_cancelamento;
	}

}
