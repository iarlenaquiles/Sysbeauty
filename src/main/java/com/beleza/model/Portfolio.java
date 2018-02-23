package com.beleza.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Portfolio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String vídeo;

	private List<String> fotos;

	private String descricao;

	@ManyToOne
	private Selo selos;

	@ManyToOne
	private Qualificacao qualificacao;

	public Portfolio(Integer id, String vídeo, List<String> fotos, String descricao, Selo selos,
			Qualificacao qualificacao) {
		this.id = id;
		this.vídeo = vídeo;
		this.fotos = fotos;
		this.descricao = descricao;
		this.selos = selos;
		this.qualificacao = qualificacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVídeo() {
		return vídeo;
	}

	public void setVídeo(String vídeo) {
		this.vídeo = vídeo;
	}

	public List<String> getFotos() {
		return fotos;
	}

	public void setFotos(List<String> fotos) {
		this.fotos = fotos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Selo getSelos() {
		return selos;
	}

	public void setSelos(Selo selos) {
		this.selos = selos;
	}

	public Qualificacao getQualificacao() {
		return qualificacao;
	}

	public void setQualificacao(Qualificacao qualificacao) {
		this.qualificacao = qualificacao;
	}

}
