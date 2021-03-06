package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.Profissional;
import com.beleza.model.Promocao;
import com.beleza.repository.PromocaoRepository;

@Service
public class PromocaoService {

	@Autowired
	private PromocaoRepository promocaoRepository;

	public List<Promocao> listaPromocao() {
		return promocaoRepository.findAll();
	}

	public Promocao salvarPromocao(Promocao promocao) {
		return promocaoRepository.save(promocao);
	}

	public void deletePromocao(Integer id) {
		promocaoRepository.delete(id);
	}

	public Promocao getById(Integer id) {
		return promocaoRepository.findOne(id);
	}

	public List<Promocao> getPromocaoByProfissional(Profissional profissional) {
		return promocaoRepository.getPromocoesByProfissional(profissional);
	}
}
