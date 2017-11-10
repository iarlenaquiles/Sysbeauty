package br.com.beleza.controller.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.beleza.Repository.LoginRepository;
import br.com.beleza.Repository.ProfissionalRepository;
import br.com.beleza.Repository.RoleRepository;
import br.com.beleza.Repository.ServicoRepository;
import br.com.beleza.model.Login;
import br.com.beleza.model.Profissional;
import br.com.beleza.model.Role;
import br.com.beleza.model.Servico;
import br.com.beleza.model.Usuario;

@RestController(value = "/profController")
public class ProfissionalController {

	@Autowired
	private ProfissionalRepository profissionalRepository;

	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	private Profissional Profissional = new Profissional();

	@CrossOrigin
	@PostMapping(value = "/newPro", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Profissional> newPro(@RequestBody Profissional pro) {
		//// Busca da ROLE ////
		Role userRole = roleRepository.findByRole("PROF");
		
		/// Salva o Estabelecimento ////
		pro.getLogin().setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		pro.setActive(true);
		System.out.println(pro);

		profissionalRepository.save(pro);
		return new ResponseEntity<Profissional>(pro, HttpStatus.CREATED);
	}

	@GetMapping(value = "/perfilPro/{id}", produces = "application/json")
	public ResponseEntity<Profissional> perfilPro(@PathVariable Integer id) {
		Profissional pro = new Profissional();
		pro = (Profissional) profissionalRepository.perfil(id);
		return new ResponseEntity<Profissional>(pro, HttpStatus.ACCEPTED);
	}

	/// Lista de Usuarios ///
	@GetMapping(value = "/listPro", produces = "application/json")
	public ResponseEntity<List<Profissional>> findAll() {
		List<Profissional> usuarios = (List<Profissional>) profissionalRepository.findAll();
		return new ResponseEntity<List<Profissional>>(usuarios, HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/servicos/{id}", produces = "application/json")
	public ResponseEntity<List<Servico>> servicosPro(@PathVariable Integer id) {
		List<Servico> servi = (List<Servico>) servicoRepository.servicos(id);
		return new ResponseEntity<List<Servico>>(servi, HttpStatus.ACCEPTED);
	}

	public Profissional getProfissional() {
		return Profissional;
	}

	public void setProfissional(Profissional profissional) {
		Profissional = profissional;
	}

}
