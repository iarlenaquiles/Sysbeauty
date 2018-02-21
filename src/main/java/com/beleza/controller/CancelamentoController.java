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

import com.beleza.model.Cancelamento;
import com.beleza.service.CancelamentoService;

@RestController
public class CancelamentoController {

	@Autowired
	CancelamentoService cancelamentoService;

	@GetMapping("/cancelamentos")
	public List<Cancelamento> listar() {
		return this.cancelamentoService.listaCancelamentos();
	}

	@GetMapping("/cancelamentos/{id}")
	public Cancelamento getById(@PathVariable Integer id) {
		return this.cancelamentoService.getById(id);
	}

	@PostMapping("/cancelamentos")
	public Cancelamento salvar(@RequestBody Cancelamento cancelamento) {
		return this.cancelamentoService.salvarCancelamento(cancelamento);
	}

	@PutMapping("/cancelamentos")
	public Cancelamento editar(@RequestBody Cancelamento cancelamento) {
		return this.cancelamentoService.salvarCancelamento(cancelamento);
	}

	@DeleteMapping("/cancelamentos/{id}")
	public void deletar(@PathVariable Integer id) {
		this.cancelamentoService.deleteCancelamento(id);
	}
}
