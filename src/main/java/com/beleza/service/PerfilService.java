package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.Perfil;
import com.beleza.repository.PerfilRepository;

@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	public List<Perfil> listaPerfil() {
		return perfilRepository.findAll();
	}
	
	public Perfil salvarPerfil(Perfil perfil) {
		return perfilRepository.save(perfil);
	}
	
	public void deletePerfil(Integer id) {
		perfilRepository.delete(id);
	}
	
	public Perfil getById(Integer id) {
		return perfilRepository.findOne(id);
	}

}
