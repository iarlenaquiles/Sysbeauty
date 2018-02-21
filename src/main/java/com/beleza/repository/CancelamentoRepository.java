package com.beleza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beleza.model.Cancelamento;

@Repository
public interface CancelamentoRepository extends JpaRepository<Cancelamento, Integer>{

}
