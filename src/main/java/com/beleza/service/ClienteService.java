package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.Cliente;
import com.beleza.model.Usuario;
import com.beleza.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listaClientes() {
		return clienteRepository.findAll();
	}
	
	public Cliente salvarCliente(Cliente cli) {
		return clienteRepository.save(cli);
	}
	
	public void deleteCliente(Integer id) {
		clienteRepository.delete(id);
	}
	
	public Cliente getById(Integer id) {
		return clienteRepository.findOne(id);
	}
	
	public Cliente getByUsuario(Usuario usuario) {
		return clienteRepository.getByUsuario(usuario);
	}

}
