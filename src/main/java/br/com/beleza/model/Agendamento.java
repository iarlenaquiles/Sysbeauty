package br.com.beleza.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Agendamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "agendamento_id")
	private Integer id;

	@Column(name = "ag_dataServico")
	private String dataServico;
	
	@Column(name = "ag_horarioTermino")
	private String horarioTermino;

	@Column(name = "ag_local")
	private int local;

	@Column(name = "ag_status")
	private boolean status;
	
	@Column(name = "ag_qualificacao")
	private Integer qualificacao;
	
	@Column(name = "ag_observacoes")
	private String observacoes;

	@ManyToOne
	@JoinColumn
	private Servico servico;

	@ManyToOne
	@JoinColumn
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn
	private Profissional profissional;
	//////////////// GET SET ////////////////

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataServico() {
		return dataServico;
	}
	
	public void setDataServico(String dataServico) {
		this.dataServico = dataServico;
	}
	
	public String getHorarioTermino() {
		return horarioTermino;
	}
	
	public void setHorarioTermino(String horarioTermino) {
		this.horarioTermino = horarioTermino;
	}

	public int getLocal() {
		return local;
	}
	
	public void setLocal(int local) {
		this.local = local;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Integer getQualificacao() {
		return qualificacao;
	}
	
	public void setQualificacao(Integer qualificacao) {
		this.qualificacao = qualificacao;
	}
	
	public String getObservacoes() {
		return observacoes;
	}
	
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

}
