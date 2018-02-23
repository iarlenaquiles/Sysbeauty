package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.Plano;
import com.beleza.repository.PlanoRepository;

@Service
public class PlanoService {

	@Autowired
	private PlanoRepository planoRepository;

	public List<Plano> listaPlanos() {
		return planoRepository.findAll();
	}

	public Plano salvarPlano(Plano plano) {
		return planoRepository.save(plano);
	}

	public void deletePlano(Integer id) {
		planoRepository.delete(id);
	}

	public Plano getById(Integer id) {
		return planoRepository.findOne(id);
	}

}
