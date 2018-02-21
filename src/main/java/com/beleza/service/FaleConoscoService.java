package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.FaleConosco;
import com.beleza.repository.FaleConoscoRepository;

@Service
public class FaleConoscoService {

	@Autowired
	FaleConoscoRepository faleRepository;
	
	public List<FaleConosco> listaFale() {
		return faleRepository.findAll();
	}
	
	public FaleConosco salvarFaleConosco(FaleConosco fale) {
		return faleRepository.save(fale);
	}
	
	public void deleteFaleConosco(Integer id) {
		faleRepository.delete(id);
	}
	
	public FaleConosco getById(Integer id) {
		return faleRepository.findOne(id);
	}
}
