package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.Agendamento;
import com.beleza.repository.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public List<Agendamento> listaAgendamentos() {
		return agendamentoRepository.findAll();
	}
	
	public Agendamento salvarAgendamento(Agendamento agendamento) {
		return agendamentoRepository.save(agendamento);
	}
	
	public void deleteAgendamento(Integer id) {
		agendamentoRepository.delete(id);
	}
	
	public Agendamento getById(Integer id) {
		return agendamentoRepository.findOne(id);
	}
}
