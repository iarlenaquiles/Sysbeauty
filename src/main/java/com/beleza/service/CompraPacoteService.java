package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.ComprarPacote;
import com.beleza.repository.CompraPacoteRepository;

@Service
public class CompraPacoteService {

	@Autowired
	private CompraPacoteRepository compraRepository;
	
	public List<ComprarPacote> listaClientes() {
		return compraRepository.findAll();
	}
	
	public ComprarPacote salvarCompra(ComprarPacote comprarPacote) {
		return compraRepository.save(comprarPacote);
	}
	
	public void deleteCompraPacote(Integer id) {
		compraRepository.delete(id);
	}
	
	public ComprarPacote getById(Integer id) {
		return compraRepository.findOne(id);
	}
}
