package com.beleza.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beleza.model.Usuario;
import com.beleza.service.UsuarioService;

@RestController
public class ResetSenhaController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/public/resetsenha")
	public String resetSenha(@RequestBody String email) {
		Usuario usuario = this.usuarioService.getByEmail(email);

		String token = UUID.randomUUID().toString();
		if (usuario != null) {
			this.usuarioService.createResetSenhaUsuario(usuario, token);
			// Criar mailsender
			return "Email enviado";
		}
		return "Usuário não encontrado";
	}

}
