package com.beleza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beleza.model.Ajuda;

@Repository
public interface AjudaRepository extends JpaRepository<Ajuda, Integer> {

}
