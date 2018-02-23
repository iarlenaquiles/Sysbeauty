package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.Qualificacao;
import com.beleza.repository.QualificacaoRepository;

@Service
public class QualificacaoService {
	
	@Autowired
	private QualificacaoRepository qualificacaoRepository;
	
	public List<Qualificacao> listaQualificacoes() {
		return qualificacaoRepository.findAll();
	}
	
	public Qualificacao salvarQualificacao(Qualificacao qualificacao) {
		return qualificacaoRepository.save(qualificacao);
	}
	
	public void deleteQualificacao(Integer id) {
		qualificacaoRepository.delete(id);
	}
	
	public Qualificacao getById(Integer id) {
		return qualificacaoRepository.findOne(id);
	}

}
