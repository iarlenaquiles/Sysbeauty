package com.beleza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beleza.model.Agendamento;
import com.beleza.model.Profissional;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
	List<Agendamento> getByProfissional(Profissional profissional);
}
