package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.Ajuda;
import com.beleza.repository.AjudaRepository;

@Service
public class AjudaService {

	@Autowired
	private AjudaRepository ajudaRepository;
	
	public List<Ajuda> listaAjudas() {
		return ajudaRepository.findAll();
	}
	
	public Ajuda salvarAjuda(Ajuda ajuda) {
		return ajudaRepository.save(ajuda);
	}
	
	public void deleteAjuda(Integer id) {
		ajudaRepository.delete(id);
	}
	
	public Ajuda getById(Integer id) {
		return ajudaRepository.findOne(id);
	}

}
