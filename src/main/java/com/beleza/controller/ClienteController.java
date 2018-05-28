package com.beleza.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.beleza.model.Cliente;
import com.beleza.model.Usuario;
import com.beleza.service.ClienteService;
import com.beleza.service.UploadService;
import com.beleza.service.UsuarioService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UploadService uploadService;

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

	@PutMapping("/clientes")
	public Cliente editar(@RequestBody Cliente cliente) {
		this.usuarioService.salvarUsuario(cliente.getUsuario());

		return this.clienteService.salvarCliente(cliente);
	}

	@DeleteMapping("/clientes/{id}")
	public void deletar(@PathVariable Integer id) {
		this.clienteService.deleteCliente(id);
	}

	@GetMapping("/clientes/logado")
	public Cliente getClienteLogado(Principal principal) {
		Usuario usuario = this.usuarioService.getByEmail(principal.getName());

		return this.clienteService.getByUsuario(usuario);
	}

	@PostMapping("/public/upload")
	public String upload(@RequestParam("foto") MultipartFile[] foto) throws IllegalStateException, IOException {
		return this.uploadService.uploadCliente(foto);
	}
	
	@GetMapping("/clientes/quantidade")
	public long getQuantidadeCadastros() {
		return this.clienteService.getQuantidadeCadastros();
	}

}
