package br.com.beleza.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	/* Referente a variável status
	 *
	 * 0 solicitado agendamento(cliente)
	 * 1 aprovado(pro.)
	 * 2 encerrado
	 * 3 cancelado	*/
	@Column(name = "ag_status")
	private Integer status;

	@Column(name = "ag_qualificacao")
	private Integer qualificacao;

	@Column(name = "ag_observacoes")
	private String observacoes;
	
	@Column(name = "ag_allDay")
	private Boolean allDay = false;

	// @ManyToOne
	// @JoinColumn
	// private Servico servico;
	
	@ManyToOne
	@JoinColumn
	private Usuario usuario;

	@ManyToOne
	@JoinColumn
	private Profissional profissional;

	@ManyToMany
	@JoinTable(name = "ag_serv", joinColumns = @JoinColumn(name = "agendamento_id"), inverseJoinColumns = @JoinColumn(name = "servico_id"))
	private Set<Servico> servico;
	
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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
	
	public Boolean getAllDay() {
		return allDay;
	}

	public void setAllDay(Boolean allDay) {
		this.allDay = allDay;
	}

	public Set<Servico> getServico() {
		return servico;
	}

	public void setServico(Set<Servico> servico) {
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

	@Override
	public String toString() {
		return "Agendamento [id=" + id + ", dataServico=" + dataServico + ", horarioTermino=" + horarioTermino
				+ ", local=" + local + ", status=" + status + ", qualificacao=" + qualificacao + ", observacoes="
				+ observacoes + ", usuario=" + usuario + ", profissional=" + profissional + ", servico=" + servico
				+ "]";
	}

	public Agendamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataServico == null) ? 0 : dataServico.hashCode());
		result = prime * result + ((horarioTermino == null) ? 0 : horarioTermino.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + local;
		result = prime * result + ((observacoes == null) ? 0 : observacoes.hashCode());
		result = prime * result + ((profissional == null) ? 0 : profissional.hashCode());
		result = prime * result + ((qualificacao == null) ? 0 : qualificacao.hashCode());
		result = prime * result + ((servico == null) ? 0 : servico.hashCode());
		result = prime * result + status;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	public Agendamento(Integer id, String dataServico, String horarioTermino, int local, int status,
			Integer qualificacao, String observacoes, Usuario usuario, Profissional profissional,
			Set<Servico> servico) {
		super();
		this.id = id;
		this.dataServico = dataServico;
		this.horarioTermino = horarioTermino;
		this.local = local;
		this.status = status;
		this.qualificacao = qualificacao;
		this.observacoes = observacoes;
		this.usuario = usuario;
		this.profissional = profissional;
		this.servico = servico;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agendamento other = (Agendamento) obj;
		if (dataServico == null) {
			if (other.dataServico != null)
				return false;
		} else if (!dataServico.equals(other.dataServico))
			return false;
		if (horarioTermino == null) {
			if (other.horarioTermino != null)
				return false;
		} else if (!horarioTermino.equals(other.horarioTermino))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (local != other.local)
			return false;
		if (observacoes == null) {
			if (other.observacoes != null)
				return false;
		} else if (!observacoes.equals(other.observacoes))
			return false;
		if (profissional == null) {
			if (other.profissional != null)
				return false;
		} else if (!profissional.equals(other.profissional))
			return false;
		if (qualificacao == null) {
			if (other.qualificacao != null)
				return false;
		} else if (!qualificacao.equals(other.qualificacao))
			return false;
		if (servico == null) {
			if (other.servico != null)
				return false;
		} else if (!servico.equals(other.servico))
			return false;
		if (status != other.status)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
