package com.beleza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beleza.model.Portfolio;
import com.beleza.service.PortfolioService;

@RestController
public class PortfolioController {
	
	@Autowired
	PortfolioService portfolioService;

	@GetMapping("/portfolios")
	public List<Portfolio> listar() {
		return this.portfolioService.listaPortfolios();
	}

	@GetMapping("/portfolios/{id}")
	public Portfolio getById(@PathVariable Integer id) {
		return this.portfolioService.getById(id);
	}

	@PostMapping("/portfolios")
	public Portfolio salvar(@RequestBody Portfolio portfolio) {
		return this.portfolioService.salvarPortfolio(portfolio);
	}

	@PutMapping("/portfolios")
	public Portfolio editar(@RequestBody Portfolio portfolio) {
		return this.portfolioService.salvarPortfolio(portfolio);
	}

	@DeleteMapping("/portfolios/{id}")
	public void deletar(@PathVariable Integer id) {
		this.portfolioService.deletePortfolio(id);
	}

}
