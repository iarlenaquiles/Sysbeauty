package com.beleza.service;

import java.util.Calendar;
import java.util.Date;
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
		Date data_expiracao = new Date();
		data_expiracao.getTime();
		data_expiracao.setMinutes(data_expiracao.getMinutes() + 5);

		ResetSenha myToken = new ResetSenha(token, usuario, data_expiracao);
		resetRepository.save(myToken);
	}

	public Boolean validarResetSenha(Integer id, String token) {
		ResetSenha reset = resetRepository.findByToken(token);

		if ((reset == null) || (reset.getUsuario().getId() != id)) {
			return false;
		}

		Calendar cal = Calendar.getInstance();
		if ((reset.getData_expiracao().getTime() - cal.getTime().getTime()) <= 0) {
			return false;
		}

		return true;

	}
}
