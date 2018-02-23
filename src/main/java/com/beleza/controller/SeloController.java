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

import com.beleza.model.Selo;
import com.beleza.service.SeloService;

@RestController
public class SeloController {
	@Autowired
	SeloService seloService;

	@GetMapping("/selos")
	public List<Selo> listar() {
		return this.seloService.listaSelos();
	}

	@GetMapping("/selos/{id}")
	public Selo getById(@PathVariable Integer id) {
		return this.seloService.getById(id);
	}

	@PostMapping("/selos")
	public Selo salvar(@RequestBody Selo selo) {
		return this.seloService.salvarSelo(selo);
	}

	@PutMapping("/selos")
	public Selo editar(@RequestBody Selo selo) {
		return this.seloService.salvarSelo(selo);
	}

	@DeleteMapping("/selos/{id}")
	public void deletar(@PathVariable Integer id) {
		this.seloService.deleteSelo(id);
	}
}
