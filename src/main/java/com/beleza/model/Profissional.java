package com.beleza.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Profissional implements Serializable {

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

	private String comoDescobriu;

	private Atendimento atendimento;

	private String cep;

	private String cidade;

	private String estado;

	private String endereco;

	private int numero;

	private String telefone;

	private String celular;

	private String status;

//	@OneToMany(mappedBy = "profissional", targetEntity = Servico.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<Servico> servicos;

	@OneToOne
	private Portfolio portfolio;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "usuario_id")
	private Usuario usuario;

	public Profissional(Integer id, String nome, String foto, String cpf, String email, String comoDescobriu,
			Atendimento atendimento, String cep, String cidade, String estado, String endereco, int numero,
			String telefone, String celular, String status, List<Servico> servicos) {
		super();
		this.id = id;
		this.nome = nome;
		this.foto = foto;
		this.cpf = cpf;
		this.email = email;
		this.comoDescobriu = comoDescobriu;
		this.atendimento = atendimento;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.endereco = endereco;
		this.numero = numero;
		this.telefone = telefone;
		this.celular = celular;
		this.status = status;
		//this.servicos = servicos;
	}

	public Profissional() {

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

	public String getComoDescobriu() {
		return comoDescobriu;
	}

	public void setComoDescobriu(String comoDescobriu) {
		this.comoDescobriu = comoDescobriu;
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

//	public List<Servico> getServicos() {
//		return servicos;
//	}
//
//	public void setServicos(List<Servico> servicos) {
//		this.servicos = servicos;
//	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
