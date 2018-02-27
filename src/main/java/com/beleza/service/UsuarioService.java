package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.Usuario;
import com.beleza.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

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
}
