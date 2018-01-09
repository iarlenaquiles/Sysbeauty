package br.com.beleza.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.beleza.model.Agendamento;

public interface AgendamentoRepository extends CrudRepository<Agendamento, Integer> {
	
	@Query(value = "SELECT * FROM beleza.agendamento where agendamento.usuario_usuario_id = :id ", nativeQuery = true)
	public List<Agendamento> agendamento(@Param("id") Integer id);
	
	@Query(value = "SELECT * FROM beleza.agendamento where ag_status != 3 and profissional_pro_id = :id", nativeQuery = true)
	public List<Agendamento> agAprovacao(@Param("id") Integer id);
}
