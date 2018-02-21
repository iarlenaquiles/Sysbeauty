package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.Cancelamento;
import com.beleza.repository.CancelamentoRepository;

@Service
public class CancelamentoService {

	@Autowired
	CancelamentoRepository cancelamentoRepository;
	
	public List<Cancelamento> listaCancelamentos() {
		return cancelamentoRepository.findAll();
	}
	
	public Cancelamento salvarCancelamento(Cancelamento cancelamento) {
		return cancelamentoRepository.save(cancelamento);
	}
	
	public void deleteCancelamento(Integer id) {
		cancelamentoRepository.delete(id);
	}
	
	public Cancelamento getById(Integer id) {
		return cancelamentoRepository.findOne(id);
	}
}
