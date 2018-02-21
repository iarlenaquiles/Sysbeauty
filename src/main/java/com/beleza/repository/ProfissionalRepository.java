package com.beleza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beleza.model.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {

}
