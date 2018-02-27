package com.beleza.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beleza.model.Usuario;
import com.beleza.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<Usuario> listar() {
		return this.usuarioService.listaUsuario();
	}
	
	@GetMapping("/usuarios/{id}")
	public Usuario getById(@PathVariable Integer id) {
		return this.usuarioService.getById(id);
	}
	
	@PostMapping("/usuarios")
	public Usuario salvar(@RequestBody Usuario usuario) {
		return this.usuarioService.salvarUsuario(usuario);
	}
	
	@PutMapping("/usuarios")
	public Usuario editar(@RequestBody Usuario usuario) {
		return this.usuarioService.salvarUsuario(usuario);
	}
	
	@DeleteMapping("/usuarios/{id}")
	public void deletar(@PathVariable Integer id) {
		this.usuarioService.deletarUsuario(id);
	}
	
	@PostMapping("/usuarios/reset")
	public String resetSenha(@RequestParam("email") String email) {
		Usuario usuario = this.usuarioService.getByEmail(email);
		
		if (usuario == null) {
			throw new UsernameNotFoundException(email);
		}
		
		String token = UUID.randomUUID().toString();
		this.usuarioService.createResetSenhaUsuario(usuario, token);
		
		//Criar mailsender
		return "Email enviado";
	}
	
	

}
