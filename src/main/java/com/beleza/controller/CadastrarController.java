package com.beleza.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beleza.model.Cliente;
import com.beleza.model.Perfil;
import com.beleza.model.Profissional;
import com.beleza.model.Usuario;
import com.beleza.service.ClienteService;
import com.beleza.service.PerfilService;
import com.beleza.service.ProfissionalService;
import com.beleza.service.UsuarioService;

@RestController
public class CadastrarController {
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ProfissionalService profissionalService;
	
	@Autowired
	PerfilService perfilService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping("/public/cadastrarcliente")
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		Perfil perfil = perfilService.getByNome("ROLE_CLIENTE");
		
		List<Perfil> perfiluser = new ArrayList<>();
		perfiluser.add(perfil);
		
		Usuario usuario = cliente.getUsuario();
		usuario.setPerfil(perfiluser);
		usuarioService.salvarUsuario(usuario);
		
		cliente.setUsuario(usuario);
		
		return this.clienteService.salvarCliente(cliente);
	}
	
	@PostMapping("/public/cadastrarprofissional")
	public Profissional salvarProfissional() {
		Perfil perfil = perfilService.getByNome("ROLE_PROFISSIONAL");
		List<Perfil> perfiluser = new ArrayList<>();
		perfiluser.add(perfil);
		
		return null;
	}
}
