package com.beleza.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.Agendamento;
import com.beleza.repository.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@PersistenceContext
	private EntityManager em;
	
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
	
	public List<Agendamento> getByProfissional(Integer id) {
		return null;
	}
}
