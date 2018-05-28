package com.beleza.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beleza.model.Moderador;
import com.beleza.model.Perfil;
import com.beleza.model.Usuario;
import com.beleza.service.MederadorService;
import com.beleza.service.PerfilService;
import com.beleza.service.UsuarioService;

@RestController
public class ModeradorController {

	@Autowired
	private MederadorService moderadorService;

	@Autowired
	private PerfilService perfilService;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/moderadores")
	public List<Moderador> listar() {
		return this.moderadorService.listaModeradores();
	}

	@GetMapping("/moderadores/{id}")
	public Moderador getById(@PathVariable Integer id) {
		return this.moderadorService.getById(id);
	}

	@PostMapping("/moderadores")
	public Moderador salvar(@RequestBody Moderador moderador) {
		List<Perfil> perfis = perfilService.listaPerfil();

		if (perfis.isEmpty()) {
			perfilService.salvarPerfil(new Perfil("ROLE_CLIENTE"));
			perfilService.salvarPerfil(new Perfil("ROLE_PROFISSIONAL"));
			perfilService.salvarPerfil(new Perfil("ROLE_MODERADOR"));
		}

		Perfil perfil = perfilService.getByNome("ROLE_MODERADOR");
		List<Perfil> perfiluser = new ArrayList<>();

		perfiluser.add(perfil);

		Usuario usuario = moderador.getUsuario();
		usuario.setPerfil(perfiluser);
		usuarioService.salvarUsuario(usuario);
		return this.moderadorService.salvarModerador(moderador);
	}

	@PutMapping("/moderadores")
	public Moderador editar(@RequestBody Moderador moderador) {
		usuarioService.salvarUsuario(moderador.getUsuario());
		return this.moderadorService.salvarModerador(moderador);
	}

	@DeleteMapping("/moderadores/{id}")
	public void deletar(@PathVariable Integer id) {
		this.moderadorService.deleteModerador(id);
	}

}
