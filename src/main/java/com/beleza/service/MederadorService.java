package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.Moderador;
import com.beleza.repository.ModeradorRepository;

@Service
public class MederadorService {

	@Autowired
	private ModeradorRepository moderadorRepository;

	public List<Moderador> listaModeradores() {
		return moderadorRepository.findAll();
	}

	public Moderador salvarModerador(Moderador moderador) {
		return moderadorRepository.save(moderador);
	}

	public void deleteModerador(Integer id) {
		moderadorRepository.delete(id);
	}

	public Moderador getById(Integer id) {
		return moderadorRepository.findOne(id);
	}

}
