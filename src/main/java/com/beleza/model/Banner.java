package com.beleza.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Banner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private String imagem;

	@Transient
	private String imagemData;

	private Date dataInserido;

	private TipoPublicacao tipo;

	public Banner(Integer id, String nome, String imagem, Date dataInserido, TipoPublicacao tipo) {
		this.id = id;
		this.nome = nome;
		this.imagem = imagem;
		this.dataInserido = dataInserido;
		this.tipo = tipo;
	}
	
	public Banner() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getImagemData() {
		return imagemData;
	}

	public void setImagemData(String imagemData) {
		this.imagemData = imagemData;
	}

	public Date getDataInserido() {
		return dataInserido;
	}

	public void setDataInserido(Date dataInserido) {
		this.dataInserido = dataInserido;
	}

	public TipoPublicacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoPublicacao tipo) {
		this.tipo = tipo;
	}

}
