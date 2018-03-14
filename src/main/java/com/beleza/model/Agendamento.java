package com.beleza.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Agendamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Date data_agendamento;

	private String horario;

	private Atendimento atendimento;

	private int status;

	@ManyToOne
	private Profissional profissional;

	@ManyToOne
	private Cliente cliente;

	@ManyToMany
	private Set<Servico> servico;

	public Agendamento(Integer id, Date data_agendamento, String horario, Atendimento atendimento, int status,
			Profissional profissional, Cliente cliente, Set<Servico> servico) {
		this.id = id;
		this.data_agendamento = data_agendamento;
		this.horario = horario;
		this.atendimento = atendimento;
		this.status = status;
		this.profissional = profissional;
		this.cliente = cliente;
		this.servico = servico;
	}

	public Agendamento() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData_agendamento() {
		return data_agendamento;
	}

	public void setData_agendamento(Date data_agendamento) {
		this.data_agendamento = data_agendamento;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Servico> getServico() {
		return servico;
	}

	public void setServico(Set<Servico> servico) {
		this.servico = servico;
	}

}
