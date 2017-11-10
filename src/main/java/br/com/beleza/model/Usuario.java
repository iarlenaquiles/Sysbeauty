package br.com.beleza.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "usuario_id")
	private Integer id;

	@Column(name = "usuario_dataSetting")
	private Date dataSetting;

	@Column(name = "usuario_nome")
	@NotBlank(message = "Nome é uma informação obrigatória.") // Define qual mensagem será exibida caso a validação da
																// coluna falhar
	private String nome;

	@Column(name = "usuario_email")
	private String email;

	@Column(name = "usuario_cpf")
	private String cpf;

	@Column(name = "usuario_senha")
	private String senha;

	@Column(name = "usuario_confsenha")
	private String confsenha;

	@Column(name = "usuario_cidade")
	private String cidade;

	@Column(name = "usuario_estado")
	private String estado;

	@Column(name = "usuario_endereco")
	private String endereco;

	@Column(name = "usuario_num")
	private Integer num;

	@Column(name = "usuario_cep")
	private String cep;

	@Column(name = "usuario_celular")
	private String celular;

	@Column(name = "usuario_telefone")
	private String telefone;

	@Column(name = "usuario_descobri")
	private String descobriu;

	@Column(name = "usuario_active")
	private Boolean active;

	@ManyToOne
	@JoinColumn
	private Login login;

	// @ManyToMany(cascade = CascadeType.ALL)
	// @JoinTable(name = "user_role", joinColumns = @JoinColumn(name =
	// "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	// private Set<Role> roles;

	public Usuario() {

	}

	//////////////// GET SET /////////////////////

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getConfsenha() {
		return confsenha;
	}

	public void setConfsenha(String confsenha) {
		this.confsenha = confsenha;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataSetting() {
		return dataSetting;
	}

	public void setDataSetting(Date dataSetting) {
		this.dataSetting = dataSetting;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDescobriu() {
		return descobriu;
	}

	public void setDescobriu(String descobriu) {
		this.descobriu = descobriu;
	}

	// public Set<Role> getRoles() {
	// return roles;
	// }
	//
	// public void setRoles(Set<Role> roles) {
	// this.roles = roles;
	// }

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", dataSetting=" + dataSetting + ", nome=" + nome + ", email=" + email + ", senha="
				+ senha + ", cidade=" + cidade + ", estado=" + estado + ", endereco=" + endereco + ", num=" + num
				+ ", celular=" + celular + ", telefone=" + telefone + ", descobriu=" + descobriu + "]";
	}

}
