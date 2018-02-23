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

import com.beleza.model.ComprarPacote;
import com.beleza.service.CompraPacoteService;

@RestController
public class CompraPacoteController {
	
	@Autowired
	CompraPacoteService compraService;

	@GetMapping("/comprapacote")
	public List<ComprarPacote> listar() {
		return this.compraService.listaCompras();
	}

	@GetMapping("/comprapacote/{id}")
	public ComprarPacote getById(@PathVariable Integer id) {
		return this.compraService.getById(id);
	}

	@PostMapping("/comprapacote")
	public ComprarPacote salvar(@RequestBody ComprarPacote comprarPacote) {
		return this.compraService.salvarCompra(comprarPacote);
	}

	@PutMapping("/comprapacote")
	public ComprarPacote editar(@RequestBody ComprarPacote comprarPacote) {
		return this.compraService.salvarCompra(comprarPacote);
	}

	@DeleteMapping("/comprapacote/{id}")
	public void deletar(@PathVariable Integer id) {
		this.compraService.deleteCompraPacote(id);
	}

}
