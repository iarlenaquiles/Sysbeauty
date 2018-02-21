package com.beleza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beleza.model.FaleConosco;

@Repository
public interface FaleConoscoRepository extends JpaRepository<FaleConosco, Integer> {

}
