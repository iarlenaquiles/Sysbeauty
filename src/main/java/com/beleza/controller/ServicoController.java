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

import com.beleza.model.Servico;
import com.beleza.service.ServicoService;

@RestController
public class ServicoController {
	@Autowired
	ServicoService servicoService;

	@GetMapping("/servicos")
	public List<Servico> listar() {
		return this.servicoService.listaServicos();
	}

	@PostMapping("/servicos")
	public Servico salvar(@RequestBody Servico servico) {
		return this.servicoService.salvarServico(servico);
	}

	@PutMapping("/servicos")
	public Servico editar(@RequestBody Servico servico) {
		return this.servicoService.salvarServico(servico);
	}
	
	@GetMapping("/servicos/{id}/profissional")
	public List<Servico> getServicosByProfissional(@PathVariable Integer id) {
		return this.servicoService.getServicosByProfissional(id);
	}

	@DeleteMapping("/servicos/{id}")
	public void deletar(@PathVariable Integer id) {
		this.servicoService.deleteServico(id);
	}
	
	@GetMapping("/servicos/{id}")
	public Servico getById(@PathVariable Integer id) {
		return this.servicoService.getById(id);
	}
}
