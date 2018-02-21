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

import com.beleza.model.Cliente;
import com.beleza.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return this.clienteService.listaClientes();
	}

	@GetMapping("/clientes/{id}")
	public Cliente getById(@PathVariable Integer id) {
		return this.clienteService.getById(id);
	}

	@PostMapping("/clientes")
	public Cliente salvar(@RequestBody Cliente cliente) {
		return this.clienteService.salvarCliente(cliente);
	}

	@PutMapping("/Clientes")
	public Cliente editar(@RequestBody Cliente cliente) {
		return this.clienteService.salvarCliente(cliente);
	}

	@DeleteMapping("/clientes/{id}")
	public void deletar(@PathVariable Integer id) {
		this.clienteService.deleteCliente(id);
	}

}
