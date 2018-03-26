package com.beleza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.beleza.model.Qualificacao;

public interface QualificacaoRepository extends JpaRepository<Qualificacao, Integer> {

	@Query(value = "SELECT qualificacao.* FROM profissional left join qualificacao on qualificacao.profissional_id = profissional.id left join cliente on cliente.id = qualificacao.cliente_id where profissional.id = ?1", nativeQuery = true)
	List<Qualificacao> getByProfissional(Integer id);

	@Query(value = "SELECT qualificacao.* FROM cliente left join qualificacao on qualificacao.cliente_id = cliente.id left join profissional on profissional.id = qualificacao.profissional_id where cliente.id = ?1", nativeQuery=true)
	List<Qualificacao> getByCliente(Integer id);

}
