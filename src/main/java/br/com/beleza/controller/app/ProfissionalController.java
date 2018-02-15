package br.com.beleza.controller.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.beleza.Repository.LoginRepository;
import br.com.beleza.Repository.ProfissionalRepository;
import br.com.beleza.Repository.PromocaoRepository;
import br.com.beleza.Repository.RoleRepository;
import br.com.beleza.Repository.ServicoRepository;
import br.com.beleza.model.Profissional;
import br.com.beleza.model.Promocao;
import br.com.beleza.model.Role;
import br.com.beleza.model.Servico;

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
	
	@Autowired
	private PromocaoRepository promocaoRepository;

	private Profissional Profissional = new Profissional();

	@CrossOrigin
	@PostMapping(value = "/newPro", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Profissional> newPro(@RequestBody Profissional pro) {
		
		System.out.println("\n\n" + pro);
		
		//// Busca da ROLE ////
		Role userRole = roleRepository.findByRole("PROF");

		/// Salva o Estabelecimento ////
		pro.getLogin().setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		pro.setActive(true);

		profissionalRepository.save(pro);
		return new ResponseEntity<Profissional>(pro, HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/updateProf", consumes = "application/json")
	public ResponseEntity<Profissional> updateProfissional(@RequestBody Profissional pro) {
		pro.setActive(true);
		profissionalRepository.save(pro);
		return new ResponseEntity<Profissional>(pro, HttpStatus.CREATED);
	}

	@GetMapping(value = "/perfilPro/{id}", produces = "application/json")
	public ResponseEntity<Profissional> perfilPro(@PathVariable Integer id) {
		Profissional pro = new Profissional();
		pro = (Profissional) profissionalRepository.perfil(id);
		return new ResponseEntity<Profissional>(pro, HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value="/newPromocao", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Promocao> newPromocao(@RequestBody Servico servico) {
		
		Promocao promocao = new Promocao();
		
		promocao = servico.getPromocao().get(0);
		promocao.setServico(servico);
		
		promocaoRepository.save(promocao);
		
		return new ResponseEntity<Promocao>(promocao, HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value="/listarServicos", produces = "application/json", consumes = "application/json")
	public ResponseEntity<List<Servico>> listarServicos(@RequestBody Profissional profissional) {
		
		List<Servico> servicos = new ArrayList<Servico>();

		for (Servico servico : profissional.getServico()) {
			servicos.add(servico);
		}
		
		return new ResponseEntity<List<Servico>>(servicos, HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value="/deletePromocao", produces = "application/json", consumes = "application/json")
	@Rollback(false)
	public ResponseEntity<Promocao> deletePromocao(@RequestBody Promocao promocao) {
		
		promocaoRepository.delete(promocao);
		
		return new ResponseEntity<Promocao>(promocao, HttpStatus.ACCEPTED);
	}

	/// Lista de Usuarios ///
	@GetMapping(value = "/listPro", produces = "application/json")
	public ResponseEntity<List<Profissional>> findAll() {
		List<Profissional> usuarios = (List<Profissional>) profissionalRepository.findAll();
		return new ResponseEntity<List<Profissional>>(usuarios, HttpStatus.ACCEPTED);
	}

	/*@GetMapping(value = "/servicos/{id}", produces = "application/json")
	public ResponseEntity<List<Servico>> servicosPro(@PathVariable Integer id) {
		List<Servico> servi = (List<Servico>) servicoRepository.servicos(id);
		return new ResponseEntity<List<Servico>>(servi, HttpStatus.ACCEPTED);
	}*/

	////////////// Login Apk (Ok) /////////////
	@GetMapping(value = "/loginPro/{email}/{passwd}", produces = "application/json")
	public ResponseEntity<Profissional> doLogin(@PathVariable String email, @PathVariable String passwd) {
		Profissional profissional = new Profissional();
		profissional = profissionalRepository.doLoginQuery(email, passwd);

		System.out.println(profissional);
		if (profissional != null) {
			return new ResponseEntity<Profissional>(profissional, HttpStatus.OK);
		} else {
			return new ResponseEntity<Profissional>(profissional, HttpStatus.FORBIDDEN);
		}
	}

	//////////// Get and Set /////////////
	public Profissional getProfissional() {
		return Profissional;
	}

	public void setProfissional(Profissional profissional) {
		Profissional = profissional;
	}

}
