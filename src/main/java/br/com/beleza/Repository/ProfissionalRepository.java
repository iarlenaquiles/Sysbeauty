package br.com.beleza.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.beleza.model.Profissional;
import br.com.beleza.model.Servico;

public interface ProfissionalRepository extends CrudRepository<Profissional, Integer> {

	@Query(value = "SELECT * FROM profissional where pro_id = :id ", nativeQuery = true)
	public Profissional perfil(@Param("id") Integer id);

}
