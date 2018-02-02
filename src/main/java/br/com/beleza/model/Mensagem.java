package br.com.beleza.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mensagem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "msg_id")
	private Integer id;
	
	@Column(name = "msg_id_remetente")
	private Integer idRemetente;

	@Column(name = "msg_tipo_remetente")
	private String tipoRemetente;
	
	@Column(name = "msg_data")
	private Date data;
	
	@Column(name = "msg_texto")
	private String texto;

	@ManyToOne
	@JoinColumn(name = "msg_conversa")
	private Conversa conversa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdRemetente() {
		return idRemetente;
	}

	public void setIdRemetente(Integer idRemetente) {
		this.idRemetente = idRemetente;
	}

	public String getTipoRemetente() {
		return tipoRemetente;
	}

	public void setTipoRemetente(String tipoRemetente) {
		this.tipoRemetente = tipoRemetente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Conversa getConversa() {
		return conversa;
	}

	public void setConversa(Conversa conversa) {
		this.conversa = conversa;
	}

}
