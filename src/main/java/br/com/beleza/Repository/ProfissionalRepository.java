package br.com.beleza.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.beleza.model.Profissional;

public interface ProfissionalRepository extends CrudRepository<Profissional, Integer> {

	@Query(value = "SELECT * FROM profissional where pro_id = :id ", nativeQuery = true)
	public Profissional perfil(@Param("id") Integer id);
	
	@Query(value = "SELECT * FROM profissional where pro_email = :email ", nativeQuery = true)
	public Profissional perfilPorEmail(@Param("email") String email);
	
	@Query(value = "SELECT * FROM profissional WHERE pro_email = :email AND pro_senha = :senha", nativeQuery = true)
	public Profissional doLoginQuery(@Param("email") String email, @Param("senha") String senha);

}
