package br.com.beleza.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.beleza.model.Mensagem;

public interface MensagemRepository extends CrudRepository<Mensagem, Integer> {
	
	@Query(value = "SELECT *FROM beleza.mensagem WHERE msg_conversa = :conversa ORDER BY msg_data", nativeQuery = true)
	public List<Mensagem> listaMensagens(@Param("conversa") Integer conversa);

}
