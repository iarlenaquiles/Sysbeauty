package com.beleza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

}
