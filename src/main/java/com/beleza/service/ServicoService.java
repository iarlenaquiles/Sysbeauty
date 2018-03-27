package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.Servico;
import com.beleza.repository.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;
	
	public List<Servico> listaServicos() {
		return servicoRepository.findAll();
	}
	
	public Servico salvarServico(Servico servico) {
		return servicoRepository.save(servico);
	}
	
	public void deleteServico(Integer id) {
		servicoRepository.delete(id);
	}
	
	public Servico getById(Integer id) {
		return servicoRepository.findOne(id);
	}
	
	public List<Servico> getServicosByProfissional(Integer id) {
		return servicoRepository.getServicosByProfissional(id);
	}
}
