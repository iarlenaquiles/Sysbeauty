package com.beleza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beleza.model.Cliente;
import com.beleza.model.Usuario;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	Cliente getByUsuario(Usuario usuario);
	
	@Query(value = "SELECT * FROM cliente WHERE nome LIKE ?1%", nativeQuery = true)
	List<Cliente> getByNome(String nome);
}
