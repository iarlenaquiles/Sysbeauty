package br.com.beleza.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.beleza.model.Promocao;

public interface PromocaoRepository extends CrudRepository<Promocao, Integer> {
	
	@Query(value = "DELETE FROM promocao WHERE promocao_id = :id", nativeQuery = true)
	public Promocao excluir(@Param("id") Integer id);
	
	public List<Promocao> findByServicoId(Integer id);

}
