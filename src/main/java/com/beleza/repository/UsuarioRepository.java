package com.beleza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beleza.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
