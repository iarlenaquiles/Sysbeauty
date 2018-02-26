package com.beleza.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notificacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String mensagem;

	private TipoEnvio tipo;

	public Notificacao(Integer id, String mensagem, TipoEnvio tipo) {
		this.id = id;
		this.mensagem = mensagem;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public TipoEnvio getTipo() {
		return tipo;
	}

	public void setTipo(TipoEnvio tipo) {
		this.tipo = tipo;
	}

}
