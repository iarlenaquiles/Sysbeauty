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

import com.beleza.model.Plano;
import com.beleza.service.PlanoService;

@RestController
public class PlanoController {

	@Autowired
	PlanoService planoService;

	@GetMapping("/planos")
	public List<Plano> listar() {
		return this.planoService.listaPlanos();
	}

	@GetMapping("/planos/{id}")
	public Plano getById(@PathVariable Integer id) {
		return this.planoService.getById(id);
	}

	@PostMapping("/planos")
	public Plano salvar(@RequestBody Plano plano) {
		return this.planoService.salvarPlano(plano);
	}

	@PutMapping("/planos")
	public Plano editar(@RequestBody Plano plano) {
		return this.planoService.salvarPlano(plano);
	}

	@DeleteMapping("/planos/{id}")
	public void deletar(@PathVariable Integer id) {
		this.planoService.deletePlano(id);
	}
}
