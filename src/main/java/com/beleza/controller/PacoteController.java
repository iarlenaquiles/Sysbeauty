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

import com.beleza.model.Pacote;
import com.beleza.service.PacoteService;

@RestController
public class PacoteController {

	@Autowired
	PacoteService pacoteService;

	@GetMapping("/pacotes")
	public List<Pacote> listar() {
		return this.pacoteService.listaPacote();
	}

	@GetMapping("/pacotes/{id}")
	public Pacote getById(@PathVariable Integer id) {
		return this.pacoteService.getById(id);
	}

	@PostMapping("/pacotes")
	public Pacote salvar(@RequestBody Pacote pacote) {
		return this.pacoteService.salvarPacote(pacote);
	}

	@PutMapping("/pacotes")
	public Pacote editar(@RequestBody Pacote pacote) {
		return this.pacoteService.salvarPacote(pacote);
	}

	@DeleteMapping("/pacotes/{id}")
	public void deletar(@PathVariable Integer id) {
		this.pacoteService.deletePacote(id);
	}
	
}
