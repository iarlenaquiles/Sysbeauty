package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.Portfolio;
import com.beleza.repository.PortfolioRepository;

@Service
public class PortfolioService {

	@Autowired
	private PortfolioRepository portfolioRepository;
	
	public List<Portfolio> listaPortfolios() {
		return portfolioRepository.findAll();
	}
	
	public Portfolio salvarPortfolio(Portfolio portfolio) {
		return portfolioRepository.save(portfolio);
	}
	
	public void deletePortfolio(Integer id) {
		portfolioRepository.delete(id);
	}
	
	public Portfolio getById(Integer id) {
		return portfolioRepository.findOne(id);
	}
}
