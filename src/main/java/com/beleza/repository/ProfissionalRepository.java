package com.beleza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beleza.model.Profissional;
import com.beleza.model.Usuario;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {

	Profissional getByUsuario(Usuario usuario);

	List<Profissional> getByUsuarioStatusFalse();

	@Query(value = "SELECT * FROM profissional WHERE nome LIKE ?1%", nativeQuery = true)
	List<Profissional> getByNome(String nome);
	
	List<Profissional> getByEditadoTrue();
}
