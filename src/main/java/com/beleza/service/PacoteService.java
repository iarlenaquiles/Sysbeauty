package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.Pacote;
import com.beleza.repository.PacoteRepository;

@Service
public class PacoteService {
	@Autowired
	private PacoteRepository pacoteRepository;

	public List<Pacote> listaPacote() {
		return pacoteRepository.findAll();
	}

	public Pacote salvarPacote(Pacote pacote) {
		return pacoteRepository.save(pacote);
	}

	public void deletePacote(Integer id) {
		pacoteRepository.delete(id);
	}

	public Pacote getById(Integer id) {
		return pacoteRepository.findOne(id);
	}
}
