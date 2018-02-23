package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.Selo;
import com.beleza.repository.SeloRepository;

@Service
public class SeloService {
	@Autowired
	private SeloRepository seloRepository;

	public List<Selo> listaSelos() {
		return seloRepository.findAll();
	}

	public Selo salvarSelo(Selo selo) {
		return seloRepository.save(selo);
	}

	public void deleteSelo(Integer id) {
		seloRepository.delete(id);
	}

	public Selo getById(Integer id) {
		return seloRepository.findOne(id);
	}
}
