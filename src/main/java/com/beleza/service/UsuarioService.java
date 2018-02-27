package com.beleza.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.ResetSenha;
import com.beleza.model.Usuario;
import com.beleza.repository.ResetSenhaRepository;
import com.beleza.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ResetSenhaRepository resetRepository;

	public List<Usuario> listaUsuario() {
		return usuarioRepository.findAll();
	}

	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void deletarUsuario(Integer id) {
		usuarioRepository.delete(id);
	}

	public Usuario getById(Integer id) {
		return usuarioRepository.findOne(id);
	}

	public Usuario getByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	public void createResetSenhaUsuario(Usuario usuario, String token) {
		ResetSenha myToken = new ResetSenha(token, usuario);
		resetRepository.save(myToken);
	}

	public String validarResetSenha(Integer id, String token) {
		ResetSenha reset = resetRepository.findByToken(token);

		if ((reset == null) || (reset.getUsuario().getId() != id)) {
			return "Token inválido";
		}

		Calendar cal = Calendar.getInstance();
		if ((reset.getData_expiracao().getTime() - cal.getTime().getTime()) <= 0) {
			return "Token expirado";
		}
		
		return "ok";
		
	}
}
