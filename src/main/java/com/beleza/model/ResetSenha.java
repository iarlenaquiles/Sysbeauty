package com.beleza.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ResetSenha implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int EXPIRACAO = 60 * 24;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String token;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "usuario_id")
	private Usuario usuario;

	private Date data_expiracao;

	public ResetSenha(Integer id, String token, Usuario usuario, Date data_expiracao) {
		this.id = id;
		this.token = token;
		this.usuario = usuario;
		this.data_expiracao = data_expiracao;
	}

	public ResetSenha(String token, Usuario usuario, Date data_expiracao) {
		this.token = token;
		this.usuario = usuario;
		this.data_expiracao = data_expiracao;
	}

	public ResetSenha() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getData_expiracao() {
		return data_expiracao;
	}

	public void setData_expiracao(Date data_expiracao) {
		this.data_expiracao = data_expiracao;
	}

}
