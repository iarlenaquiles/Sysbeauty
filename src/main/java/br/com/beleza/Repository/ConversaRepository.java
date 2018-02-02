package br.com.beleza.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.beleza.model.Conversa;

public interface ConversaRepository extends CrudRepository<Conversa, Integer> {
	
	@Query(value = "SELECT * FROM beleza.conversa WHERE conv_profissional = :profissional AND conv_usuario = :usuario", nativeQuery = true)
	public Conversa verificarConversa(@Param("profissional") Integer profissional, @Param("usuario") Integer usuario);
	
}
