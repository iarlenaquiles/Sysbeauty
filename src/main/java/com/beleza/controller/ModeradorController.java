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

import com.beleza.model.Moderador;
import com.beleza.service.MederadorService;

@RestController
public class ModeradorController {

	@Autowired
	MederadorService moderadorService; 

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
		return this.moderadorService.salvarModerador(moderador);
	}

	@PutMapping("/moderadores")
	public Moderador editar(@RequestBody Moderador moderador) {
		return this.moderadorService.salvarModerador(moderador);
	}

	@DeleteMapping("/moderadores/{id}")
	public void deletar(@PathVariable Integer id) {
		this.moderadorService.deleteModerador(id);
	}

}
