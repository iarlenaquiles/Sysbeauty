package com.beleza.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	private String email;

	private String senha;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfil;

	private boolean permitirNotificacao;

	private boolean naoVerAviso;

	private boolean status;

	private boolean avisoCadastroAprovado;

	public Usuario(Integer id, String email, String senha, List<Perfil> perfil) {
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
	}

	public Usuario(String email, String senha, List<Perfil> perfil) {
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
		// setSenha(senha);
		this.senha = senha;
	}

	public Usuario() {

	}

	public Usuario(Usuario usuario) {
		this.email = usuario.getEmail();
		this.perfil = usuario.getPerfil();
		this.senha = usuario.getSenha();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		// this.senha = PASSWORD_ENCODER.encode(senha);
		this.senha = senha;
	}

	public List<Perfil> getPerfil() {
		return perfil
	}

	public void setPerfil(List<Perfil> perfil) {
		this.perfil = perfil;
	}

	public boolean isPermitirNotificacao() {
		return permitirNotificacao;
	}

	public void setPermitirNotificacao(boolean permitirNotificacao) {
		this.permitirNotificacao = permitirNotificacao;
	}

	public boolean isNaoVerAviso() {
		return naoVerAviso;
	}

	public void setNaoVerAviso(boolean naoVerAviso) {
		this.naoVerAviso = naoVerAviso;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isAvisoCadastroAprovado() {
		return avisoCadastroAprovado;
	}

	public void setAvisoCadastroAprovado(boolean avisoCadastroAprovado) {
		this.avisoCadastroAprovado = avisoCadastroAprovado;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", senha=" + senha + ", perfil=" + perfil + "]";
	}

}
