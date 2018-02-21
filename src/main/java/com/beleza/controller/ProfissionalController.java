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

import com.beleza.model.Profissional;
import com.beleza.service.ProfissionalService;

@RestController
public class ProfissionalController {
	@Autowired
	ProfissionalService profissionalService;

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
		return this.profissionalService.salvarProfissional(pro);
	}

	@DeleteMapping("/profissionais/{id}")
	public void deletar(@PathVariable Integer id) {
		this.profissionalService.deleteProfissional(id);
	}
}
