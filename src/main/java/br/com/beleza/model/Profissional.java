package br.com.beleza.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Profissional implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "pro_id")
	private Integer id;

	@Column(name = "pro_dataSetting")
	private Date dataSetting;

	@Column(name = "pro_nome")
	@NotBlank(message = "Nome é uma informação obrigatória.") // Define qual mensagem será exibida caso a validação da
	// coluna falhar
	private String nome;

	@Column(name = "pro_email")
	private String email;

	@Column(name = "pro_cpf")
	private String cpf;

	@Column(name = "pro_senha")
	private String senha;

	@Column(name = "pro_confsenha")
	private String confsenha;

	@Column(name = "pro_cidade")
	private String cidade;

	@Column(name = "pro_estado")
	private String estado;

	@Column(name = "pro_endereco")
	private String endereco;

	@Column(name = "pro_num")
	private Integer num;

	@Column(name = "pro_cep")
	private String cep;

	@Column(name = "pro_celular")
	private String celular;

	@Column(name = "pro_telefone")
	private String telefone;

	@Column(name = "pro_descobri")
	private String descobriu;

	@Column(name = "pro_active")
	private Boolean active;

	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn
	private Login login;

	@OneToMany(mappedBy = "profissional",  targetEntity = Servico.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Servico> servico = new ArrayList<Servico>();

	//////////////// GET SET /////////////////////

	public String getCpf() {
		return cpf;
	}

	public Boolean getActive() {
		return active;
	}

	public List<Servico> getServico() {

		return servico;
	}

	public void setServico(List<Servico> servico) {
		for(Servico s:servico) {
			s.setProfissional(this);
		}
		this.servico = servico;
	}

	public void setActive(Boolean active) {
		this.active = active;
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

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}



	public Profissional() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profissional(Integer id, Date dataSetting, String nome, String email, String cpf, String senha,
			String confsenha, String cidade, String estado, String endereco, Integer num, String cep, String celular,
			String telefone, String descobriu, Boolean active, Login login, List<Servico> servico) {
		super();
		this.id = id;
		this.dataSetting = dataSetting;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		this.confsenha = confsenha;
		this.cidade = cidade;
		this.estado = estado;
		this.endereco = endereco;
		this.num = num;
		this.cep = cep;
		this.celular = celular;
		this.telefone = telefone;
		this.descobriu = descobriu;
		this.active = active;
		this.login = login;
		this.servico = servico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((confsenha == null) ? 0 : confsenha.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataSetting == null) ? 0 : dataSetting.hashCode());
		result = prime * result + ((descobriu == null) ? 0 : descobriu.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((servico == null) ? 0 : servico.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissional other = (Profissional) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (confsenha == null) {
			if (other.confsenha != null)
				return false;
		} else if (!confsenha.equals(other.confsenha))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataSetting == null) {
			if (other.dataSetting != null)
				return false;
		} else if (!dataSetting.equals(other.dataSetting))
			return false;
		if (descobriu == null) {
			if (other.descobriu != null)
				return false;
		} else if (!descobriu.equals(other.descobriu))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (servico == null) {
			if (other.servico != null)
				return false;
		} else if (!servico.equals(other.servico))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profissional [id=" + id + ", dataSetting=" + dataSetting + ", nome=" + nome + ", email=" + email
				+ ", cpf=" + cpf + ", senha=" + senha + ", confsenha=" + confsenha + ", cidade=" + cidade + ", estado="
				+ estado + ", endereco=" + endereco + ", num=" + num + ", cep=" + cep + ", celular=" + celular
				+ ", telefone=" + telefone + ", descobriu=" + descobriu + ", active=" + active + ", login=" + login + "]";
	}



}
