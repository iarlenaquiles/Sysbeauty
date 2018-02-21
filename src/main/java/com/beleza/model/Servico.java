package com.beleza.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Servico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome_servico;

	private Double valor;

	@ManyToOne(fetch = FetchType.LAZY)
	private Profissional profissional;

	@OneToMany(mappedBy = "servico", targetEntity = Promocao.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Promocao> promocao;

	public Servico(Integer id, String nome_servico, Double valor, Profissional profissional) {
		this.id = id;
		this.nome_servico = nome_servico;
		this.valor = valor;
		this.profissional = profissional;
	}

	public Servico() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome_servico() {
		return nome_servico;
	}

	public void setNome_servico(String nome_servico) {
		this.nome_servico = nome_servico;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public List<Promocao> getPromocao() {
		return promocao;
	}

	public void setPromocao(List<Promocao> promocao) {
		this.promocao = promocao;
	}

}
