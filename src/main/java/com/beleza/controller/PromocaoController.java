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

import com.beleza.model.Promocao;
import com.beleza.service.PromocaoService;

@RestController
public class PromocaoController {

	@Autowired
	PromocaoService promocaoService;

	@GetMapping("/promocoes")
	public List<Promocao> listar() {
		return this.promocaoService.listaPromocao();
	}

	@GetMapping("/promocoes/{id}")
	public Promocao getById(@PathVariable Integer id) {
		return this.promocaoService.getById(id);
	}

	@PostMapping("/promocoes")
	public Promocao salvar(@RequestBody Promocao promocao) {
		return this.promocaoService.salvarPromocao(promocao);
	}

	@PutMapping("/promocoes")
	public Promocao editar(@RequestBody Promocao promocao) {
		return this.promocaoService.salvarPromocao(promocao);
	}

	@DeleteMapping("/promocoes/{id}")
	public void deletar(@PathVariable Integer id) {
		this.promocaoService.deletePromocao(id);
	}
}
