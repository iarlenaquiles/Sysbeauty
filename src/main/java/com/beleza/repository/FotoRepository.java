package com.beleza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beleza.model.Fotos;

@Repository
public interface FotoRepository extends JpaRepository<Fotos, Integer>{

}
