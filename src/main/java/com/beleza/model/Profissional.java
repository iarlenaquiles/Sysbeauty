package com.beleza.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

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

	private String descobriu;

	private Atendimento atendimento;

	private String cep;

	private String cidade;

	private String estado;

	private String endereco;

	private int numero;

	private String telefone;

	private String celular;

	private StatusProfissional status;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataEdicao;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataCadastro;

	@ManyToMany
	private List<Servico> servicos;

	@ManyToOne
	private Plano plano;

	@OneToOne
	@JoinColumn(nullable = true)
	private Portfolio portfolio;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "usuario_id")
	private Usuario usuario;

	public Profissional(Integer id, String nome, String foto, String cpf, String email, String descobriu,
			Atendimento atendimento, String cep, String cidade, String estado, String endereco, int numero,
			String telefone, String celular, List<Servico> servicos, Plano plano, Date dataCadastro,
			StatusProfissional status, Date dataEdicao) {
		this.id = id;
		this.nome = nome;
		this.foto = foto;
		this.cpf = cpf;
		this.email = email;
		this.descobriu = descobriu;
		this.atendimento = atendimento;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.endereco = endereco;
		this.numero = numero;
		this.telefone = telefone;
		this.celular = celular;
		this.servicos = servicos;
		this.plano = plano;
		this.dataCadastro = dataCadastro;
		this.status = status;
		this.dataEdicao = dataEdicao;
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

	public String getDescobriu() {
		return descobriu;
	}

	public void setComoDescobriu(String descobriu) {
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

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
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

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setDescobriu(String descobriu) {
		this.descobriu = descobriu;
	}

	public StatusProfissional getStatus() {
		return status;
	}

	public void setStatus(StatusProfissional status) {
		this.status = status;
	}

	public Date getDataEdicao() {
		return dataEdicao;
	}

	public void setDataEdicao(Date dataEdicao) {
		this.dataEdicao = dataEdicao;
	}

	@Override
	public String toString() {
		return "Profissional [id=" + id + ", nome=" + nome + ", foto=" + foto + ", cpf=" + cpf + ", email=" + email
				+ ", descobriu=" + descobriu + ", atendimento=" + atendimento + ", cep=" + cep + ", cidade=" + cidade
				+ ", estado=" + estado + ", endereco=" + endereco + ", numero=" + numero + ", telefone=" + telefone
				+ ", celular=" + celular + ", servicos=" + servicos + ", plano=" + plano + ", portfolio=" + portfolio
				+ ", usuario=" + usuario + "]";
	}

}
