package com.beleza.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beleza.model.Cliente;
import com.beleza.model.Perfil;
import com.beleza.model.Plano;
import com.beleza.model.Profissional;
import com.beleza.model.Servico;
import com.beleza.model.Usuario;
import com.beleza.service.ClienteService;
import com.beleza.service.PerfilService;
import com.beleza.service.PlanoService;
import com.beleza.service.ProfissionalService;
import com.beleza.service.ServicoService;
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
	
	@Autowired
	ServicoService servicoService;
	
	@Autowired
	PlanoService planoService;

	@PostMapping("/public/cadastrarcliente")
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		List<Perfil> perfis = perfilService.listaPerfil();

		if (perfis.isEmpty()) {
			perfilService.salvarPerfil(new Perfil("ROLE_CLIENTE"));
			perfilService.salvarPerfil(new Perfil("ROLE_PROFISSIONAL"));
			perfilService.salvarPerfil(new Perfil("ROLE_MODERADOR"));
		}

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
	public Profissional salvarProfissional(@RequestBody Profissional profissional) {

		List<Servico> servicos = new ArrayList<Servico>();
		
		for (Servico s : profissional.getServicos()) {
			Servico servico = servicoService.salvarServico(s);
			servicos.add(servico);			
		}
		
		List<Perfil> perfis = perfilService.listaPerfil();

		if (perfis.isEmpty()) {
			perfilService.salvarPerfil(new Perfil("ROLE_CLIENTE"));
			perfilService.salvarPerfil(new Perfil("ROLE_PROFISSIONAL"));
			perfilService.salvarPerfil(new Perfil("ROLE_MODERADOR"));
		}

		Perfil perfil = perfilService.getByNome("ROLE_PROFISSIONAL");
		List<Perfil> perfiluser = new ArrayList<>();

		perfiluser.add(perfil);

		Usuario usuario = profissional.getUsuario();
		usuario.setPerfil(perfiluser);
		usuarioService.salvarUsuario(usuario);
		
		Plano plano = planoService.getById(1);

		profissional.setPlano(plano);
		profissional.setUsuario(usuario);
		profissional.setServicos(servicos);

		return this.profissionalService.salvarProfissional(profissional);
	}
}
