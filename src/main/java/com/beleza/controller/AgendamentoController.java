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

import com.beleza.model.Agendamento;
import com.beleza.service.AgendamentoService;

@RestController
public class AgendamentoController {

	@Autowired
	AgendamentoService agendamentoService;

	@GetMapping("/agendamentos")
	public List<Agendamento> listar() {
		return this.agendamentoService.listaAgendamentos();
	}

	@GetMapping("/agendamentos/{id}")
	public Agendamento getById(@PathVariable Integer id) {
		return this.agendamentoService.getById(id);
	}

	@PostMapping("/agendamentos")
	public Agendamento salvar(@RequestBody Agendamento agendamento) {
		return this.agendamentoService.salvarAgendamento(agendamento);
	}

	@PutMapping("/agendamentos")
	public Agendamento editar(@RequestBody Agendamento agendamento) {
		return this.agendamentoService.salvarAgendamento(agendamento);
	}

	@DeleteMapping("/agendamentos/{id}")
	public void deletar(@PathVariable Integer id) {
		this.agendamentoService.deleteAgendamento(id);
	}
	
	@GetMapping("/agendamentos/{id}/profissional")
	public List<Agendamento> getByProfissional(@PathVariable Integer id){
		return this.agendamentoService.getByProfissional(id);
	}
}
