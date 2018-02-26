package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.Notificacao;
import com.beleza.repository.NotificacaoRepository;

@Service
public class NotificacaoService {

	@Autowired
	private NotificacaoRepository notificacaoRepository;

	public List<Notificacao> listaNotificacoes() {
		return notificacaoRepository.findAll();
	}

	public Notificacao salvarNotificacao(Notificacao notificacao) {
		return notificacaoRepository.save(notificacao);
	}

	public void deleteNotificacao(Integer id) {
		notificacaoRepository.delete(id);
	}

	public Notificacao getById(Integer id) {
		return notificacaoRepository.findOne(id);
	}
}
