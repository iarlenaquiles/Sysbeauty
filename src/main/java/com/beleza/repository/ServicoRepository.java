package com.beleza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beleza.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

	@Query(value = "SELECT * FROM profissional left join profissional_servicos on profissional.id = profissional_servicos.profissional_id left join servico on servico.id = profissional_servicos.servicos_id WHERE profissional.id = ?1", nativeQuery = true)
	List<Servico> getServicosByProfissional(Integer id);
}
