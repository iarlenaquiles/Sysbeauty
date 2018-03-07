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

import com.beleza.model.Ajuda;
import com.beleza.service.AjudaService;

@RestController
public class AjudaController {
	@Autowired
	private AjudaService ajudaService;

	@GetMapping("/ajudas")
	public List<Ajuda> listar() {
		return this.ajudaService.listaAjudas();
	}

	@GetMapping("/ajuda/{id}")
	public Ajuda getById(@PathVariable Integer id) {
		return this.ajudaService.getById(id);
	}

	@PostMapping("/ajuda")
	public Ajuda salvar(@RequestBody Ajuda ajuda) {
		return this.ajudaService.salvarAjuda(ajuda);
	}

	@PutMapping("/ajuda")
	public Ajuda editar(@RequestBody Ajuda ajuda) {
		return this.ajudaService.salvarAjuda(ajuda);
	}

	@DeleteMapping("/ajuda/{id}")
	public void deletar(@PathVariable Integer id) {
		this.ajudaService.deleteAjuda(id);
	}
}
