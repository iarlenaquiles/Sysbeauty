package com.beleza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beleza.model.Profissional;
import com.beleza.model.Promocao;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao, Integer> {

	List<Promocao> getPromocoesByProfissional(Profissional profissional);
}
