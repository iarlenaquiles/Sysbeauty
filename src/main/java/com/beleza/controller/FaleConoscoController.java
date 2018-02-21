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

import com.beleza.model.FaleConosco;
import com.beleza.service.FaleConoscoService;

@RestController
public class FaleConoscoController {

	@Autowired
	FaleConoscoService faleService;

	@GetMapping("/faleconosco")
	public List<FaleConosco> listar() {
		return this.faleService.listaFale();
	}

	@GetMapping("/faleconosco/{id}")
	public FaleConosco getById(@PathVariable Integer id) {
		return this.faleService.getById(id);
	}

	@PostMapping("/faleconosco")
	public FaleConosco salvar(@RequestBody FaleConosco fale) {
		return this.faleService.salvarFaleConosco(fale);
	}

	@PutMapping("/faleconosco")
	public FaleConosco editar(@RequestBody FaleConosco fale) {
		return this.faleService.salvarFaleConosco(fale);
	}

	@DeleteMapping("/faleconosco/{id}")
	public void deletar(@PathVariable Integer id) {
		this.faleService.deleteFaleConosco(id);
	}
}
