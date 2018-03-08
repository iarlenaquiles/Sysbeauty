package com.beleza.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ajuda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String pergunta;

	private String resposta;

	public Ajuda(Integer id, String pergunta, String resposta) {
		this.id = id;
		this.pergunta = pergunta;
		this.resposta = resposta;
	}
	
	public Ajuda() {
		
	}
	
	public Ajuda(String pergunta, String resposta) {
		this.pergunta = pergunta;
		this.resposta = resposta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

}
