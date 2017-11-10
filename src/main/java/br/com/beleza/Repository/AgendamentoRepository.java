package br.com.beleza.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.beleza.model.Agendamento;

public interface AgendamentoRepository extends CrudRepository<Agendamento, Integer> {
	
	@Query(value = "SELECT * FROM beleza.agendamento inner join profissional_servico on agendamento.servico_servico_id = profissional_servico.servico_servico_id\r\n" + 
			"where agendamento.usuario_usuario_id = :id ", nativeQuery = true)
	public List<Agendamento> agendamento(@Param("id") Integer id);
}
