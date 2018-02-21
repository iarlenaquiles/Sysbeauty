package com.beleza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beleza.model.Promocao;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao, Integer> {

}
