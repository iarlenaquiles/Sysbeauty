package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.Evento;
import com.beleza.repository.EventoRepository;

@Service
public class EventoService {
	@Autowired
	private EventoRepository eventoRepository;
	
	public List<Evento> listaEventos() {
		return eventoRepository.findAll();
	}
	
	public Evento salvarEvento(Evento evento) {
		return eventoRepository.save(evento);
	}
	
	public void deleteEvento(Integer id) {
		eventoRepository.delete(id);
	}
	
	public Evento getById(Integer id) {
		return eventoRepository.findOne(id);
	}
}
