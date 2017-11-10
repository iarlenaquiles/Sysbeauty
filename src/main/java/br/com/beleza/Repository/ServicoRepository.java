package br.com.beleza.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.beleza.model.Servico;

public interface ServicoRepository extends CrudRepository<Servico, Integer> {
	
	@Query(value = "SELECT * FROM beleza.servico inner join beleza.profissional_servico on servico.servico_id = profissional_servico.servico_servico_id \r\n" + 
			"where profissional_servico.profissional_pro_id = :id ", nativeQuery = true)
	public  List<Servico> servicos(@Param("id") Integer id);
}
