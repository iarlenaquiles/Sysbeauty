package com.beleza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beleza.model.Profissional;
import com.beleza.model.Qualificacao;

public interface QualificacaoRepository extends JpaRepository<Qualificacao, Integer>{

	List<Qualificacao> getByProfissional(Profissional profissional);
	
}
