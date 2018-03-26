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

import com.beleza.model.Qualificacao;
import com.beleza.service.QualificacaoService;

@RestController
public class QualificacaoController {

	@Autowired
	QualificacaoService qualificacaoService;

	@GetMapping("/qualificacoes")
	public List<Qualificacao> listar() {
		return this.qualificacaoService.listaQualificacoes();
	}

	@PostMapping("/qualificacoes")
	public Qualificacao salvar(@RequestBody Qualificacao qualificacao) {
		return this.qualificacaoService.salvarQualificacao(qualificacao);
	}

	@PutMapping("/qualificacoes")
	public Qualificacao editar(@RequestBody Qualificacao qualificacao) {
		return this.qualificacaoService.salvarQualificacao(qualificacao);
	}

	@GetMapping("/qualificacoes/{id}/profissional")
	public List<Qualificacao> getQualificacoesByProfissional(@PathVariable Integer id){
		return this.qualificacaoService.getByProfissional(id);
	}
	
	@GetMapping("/qualificacoes/{id}/cliente")
	public List<Qualificacao> getQualificacoesByCliente(@PathVariable Integer id){
		return this.qualificacaoService.getByCliente(id);
	}
	
	@DeleteMapping("/qualificacoes/{id}")
	public void deletar(@PathVariable Integer id) {
		this.qualificacaoService.deleteQualificacao(id);
	}

	@GetMapping("/qualificacoes/{id}")
	public Qualificacao getById(@PathVariable Integer id) {
		return this.qualificacaoService.getById(id);
	}
}
