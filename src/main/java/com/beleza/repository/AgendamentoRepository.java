package com.beleza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beleza.model.Agendamento;
import com.beleza.model.Profissional;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
	List<Agendamento> getByProfissional(Profissional profissional);

	@Query(value = "SELECT count(*) FROM agendamento left join profissional on profissional.id = agendamento.profissional_id where profissional.id= ?1 and agendamento.status = 2", nativeQuery = true)
	Integer quantidadeAgendamentosFinalizados(Integer idProfissional);
}
