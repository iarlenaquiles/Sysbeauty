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

	@GetMapping("/qualificacoes/{id}")
	public Qualificacao getById(@PathVariable Integer id) {
		return this.qualificacaoService.getById(id);
	}

	@PostMapping("/qualificacoes")
	public Qualificacao salvar(@RequestBody Qualificacao qualificacao) {
		return this.qualificacaoService.salvarQualificacao(qualificacao);
	}

	@PutMapping("/qualificacoes")
	public Qualificacao editar(@RequestBody Qualificacao qualificacao) {
		return this.qualificacaoService.salvarQualificacao(qualificacao);
	}

	@DeleteMapping("/qualificacoes/{id}")
	public void deletar(@PathVariable Integer id) {
		this.qualificacaoService.deleteQualificacao(id);
	}

}
