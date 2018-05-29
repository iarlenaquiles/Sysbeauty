package com.beleza.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beleza.model.Evento;
import com.beleza.model.Profissional;
import com.beleza.model.Usuario;
import com.beleza.service.EventoService;
import com.beleza.service.ProfissionalService;
import com.beleza.service.UsuarioService;

@RestController
public class ProfissionalController {
	@Autowired
	private ProfissionalService profissionalService;

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EventoService eventoService;
	
	@GetMapping("/profissionais")
	public List<Profissional> listar() {
		return this.profissionalService.listaProfissionais();
	}

	@GetMapping("/profissionais/{id}")
	public Profissional getById(@PathVariable Integer id) {
		return this.profissionalService.getById(id);
	}

	@PostMapping("/profissionais")
	public Profissional salvar(@RequestBody Profissional pro) {
		return this.profissionalService.salvarProfissional(pro);
	}

	@PutMapping("/profissionais")
	public Profissional editar(@RequestBody Profissional pro) {
		this.usuarioService.salvarUsuario(pro.getUsuario());
		return this.profissionalService.salvarProfissional(pro);
	}

	@DeleteMapping("/profissionais/{id}")
	public void deletar(@PathVariable Integer id) {
		this.profissionalService.deleteProfissional(id);
	}
	
	@GetMapping("/profissionais/logado")
	public Profissional getProfissionalLogado(Principal principal) {
		Usuario usuario = this.usuarioService.getByEmail(principal.getName());

		return this.profissionalService.getByUsuario(usuario);
	}
	
	@PostMapping("/profissionais/eventos")
	public Evento salvarEvento(@RequestBody Evento evento) {
		return this.eventoService.salvarEvento(evento);
	}
	
	@GetMapping("/profissionais/quantidade")
	public long getQuantidadeCadastros() {
		return this.profissionalService.getQuantidadeCadastros();
	}
	
	@GetMapping("/profissionais/inativos")
	public List<Profissional> getByUsuarioStatusFalse() {
		return this.profissionalService.getByUsuarioStatusFalse();
	}
}
