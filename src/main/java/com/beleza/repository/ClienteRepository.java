package com.beleza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beleza.model.Cliente;
import com.beleza.model.Usuario;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	Cliente getByUsuario(Usuario usuario);
}
