package com.beleza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beleza.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer>{

}
