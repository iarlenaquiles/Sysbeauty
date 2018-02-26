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

import com.beleza.model.Notificacao;
import com.beleza.service.NotificacaoService;

@RestController
public class NotificacaoController {

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

	@PostMapping("/notificacoes")
	public Notificacao salvar(@RequestBody Notificacao notificacao) {
		if (notificacao.getTipo().getDescricao() == "PROFISSIONAIS") {
			System.out.println("Enviar push para o profissional");
		} else if (notificacao.getTipo().getDescricao() == "CLIENTES"){
			System.out.println("Enviar push para o cliente");
		} else {
			System.out.println("Enviar push para ambos");
		}
		
		return this.notificacaoService.salvarNotificacao(notificacao);
	}

	@PutMapping("/notificacoes")
	public Notificacao editar(@RequestBody Notificacao notificacao) {
		return this.notificacaoService.salvarNotificacao(notificacao);
	}

	@DeleteMapping("/notificacoes/{id}")
	public void deletar(@PathVariable Integer id) {
		this.notificacaoService.deleteNotificacao(id);
	}

}
