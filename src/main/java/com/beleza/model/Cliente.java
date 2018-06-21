package com.beleza.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private String foto;

	private String cpf;

	private String email;

	private String descobriu;

	private String cep;

	private String cidade;

	private String estado;

	private String endereco;

	private int numero;

	private String telefone;

	private String celular;

	@Transient
	private String hashComprador;

	@Transient
	private String hashCard;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "usuario_id")
	private Usuario usuario;

	public Cliente(Integer id, String nome, String foto, String cpf, String email, String descobriu, String cep,
			String cidade, String estado, String endereco, int numero, String telefone, String celular) {
		this.id = id;
		this.nome = nome;
		this.foto = foto;
		this.cpf = cpf;
		this.email = email;
		this.descobriu = descobriu;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.endereco = endereco;
		this.numero = numero;
		this.telefone = telefone;
		this.celular = celular;
	}

	public Cliente() {

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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescobriu() {
		return descobriu;
	}

	public void setDescobriu(String descobriu) {
		this.descobriu = descobriu;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getHashComprador() {
		return hashComprador;
	}

	public void setHashComprador(String hashComprador) {
		this.hashComprador = hashComprador;
	}

	public String getHashCard() {
		return hashCard;
	}

	public void setHashCard(String hashCard) {
		this.hashCard = hashCard;
	}

}
