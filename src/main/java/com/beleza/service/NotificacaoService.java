package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.Notificacao;
import com.beleza.repository.NotificacaoRepository;

@Service
public class NotificacaoService {

	private static final String FIREBASE_SERVER_KEY = "AAAAozROEp4:APA91bFIJCJ69aDUugL6DMK_z_QA1oVYmCH-YZ-5GflB_6lFEjTvDTjdhdm7pefHwYow8cBTFg-1PDHaNjhImzKqHvlaNMSjaRPXgc_vbjDQDUDTudjvZdEEi968nke6ug5BmSSBHEhv";
	private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";
	
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
