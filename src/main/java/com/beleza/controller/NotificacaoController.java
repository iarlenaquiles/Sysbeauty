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

	@PostMapping("/notificacoes")
	public Notificacao salvar(@RequestBody Notificacao notificacao) {
		if (notificacao.getTipo().getDescricao() == "PROFISSIONAIS") {
			this.send(notificacao, TOPIC_PROFISSIONAL);
		} else if (notificacao.getTipo().getDescricao() == "CLIENTES"){
			this.send(notificacao, TOPIC_CLIENTE);
		} else {
			this.send(notificacao, TOPIC_AMBOS);
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
	
	public ResponseEntity<String> send(Notificacao notificacao, String topico) throws JSONException {

		JSONObject body = new JSONObject();
		body.put("to", "/topics/" + topico);
		body.put("priority", "high");

		JSONObject notification = new JSONObject();
		notification.put("title", "Disque beleza");
		notification.put("body", notificacao.getMensagem());

		body.put("notification", notification);

		HttpEntity<String> request = new HttpEntity<>(body.toString());

		CompletableFuture<String> pushNotification = notificacaoService.send(request);
		CompletableFuture.allOf(pushNotification).join();

		try {
			String firebaseResponse = pushNotification.get();
			
			return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
	}

}
