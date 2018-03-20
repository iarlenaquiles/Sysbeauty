package com.beleza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beleza.model.Profissional;
import com.beleza.model.Usuario;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {

	Profissional getByUsuario(Usuario usuario);
}
