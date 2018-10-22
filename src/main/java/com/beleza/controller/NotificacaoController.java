package com.beleza.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beleza.model.Notificacao;
import com.beleza.service.NotificacaoService;

@RestController
public class NotificacaoController {

	private final String TOPIC_CLIENTE = "Cliente";
	
	private final String TOPIC_PROFISSIONAL = "Profissional";
	
	private final String TOPIC_AMBOS = "Ambos";
	
	@Autowired
	NotificacaoService notificacaoService;

	@GetMapping("/notificacoes")
	public List<Notificacao> listar() {
		return this.notificacaoService.listaNotificacoes();
	}

	@GetMapping("/notificacoes/{id}")
	public Notificacao getById(@PathVariable Integer id) {
		return this.notificacaoService.getById(id);
	}

	@PutMapping("/notificacoes")
	public Notificacao editar(@RequestBody Notificacao notificacao) {
		return this.notificacaoService.salvarNotificacao(notificacao);
	}



}
