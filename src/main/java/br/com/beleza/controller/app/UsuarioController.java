package br.com.beleza.controller.app;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.beleza.Repository.AgendamentoRepository;
import br.com.beleza.Repository.IUsuario;
import br.com.beleza.Repository.LoginRepository;
import br.com.beleza.Repository.RoleRepository;
import br.com.beleza.model.Agendamento;
import br.com.beleza.model.Login;
import br.com.beleza.model.Role;
import br.com.beleza.model.Usuario;

//@CrossOrigin(origins = "http://localhost:8100", maxAge = 3600)
@RestController(value = "/controller")
public class UsuarioController {

	@Autowired
	private IUsuario iusuario;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private AgendamentoRepository agendamentoRepository;

	/// Lista de Usuarios ///
	@GetMapping(value = "/listUser", produces = "application/json")
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> usuarios = (List<Usuario>) iusuario.findAll();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.ACCEPTED);
	}

	/// Lista de Agendamentos do Usuario ///
	@GetMapping(value = "/agendamentoCli/{id}", produces = "application/json")
	public ResponseEntity<List<Agendamento>> agendamentoCli(@PathVariable Integer id) {
		List<Agendamento> usuarios = (List<Agendamento>) agendamentoRepository.agendamento(id);
		for (Agendamento list : usuarios) {
			System.out.println(list.toString());
		}
		return new ResponseEntity<List<Agendamento>>(usuarios, HttpStatus.ACCEPTED);
	}

	/// Cadastro de Cliente ///
	@CrossOrigin
	@PostMapping(value = "/newuser", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Usuario> createUser(@RequestBody Usuario usr) {
		usr.setActive(true);
		Role userRole = roleRepository.findByRole("USER");
		Login login = new Login();
		login.setActive(true);
		login.setEmail(usr.getEmail());
		login.setSenha(usr.getSenha());
		login.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		loginRepository.save(login);
		usr.setLogin(login);
		iusuario.save(usr);
		return new ResponseEntity<Usuario>(usr, HttpStatus.CREATED);
	}

	/// Cadastro de Cliente ///
	@CrossOrigin
	@PostMapping(value = "/createAgendamento", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Agendamento> createAgendamento(@RequestBody Agendamento ag) {
		
		Agendamento agendamento = new Agendamento();
		agendamento = ag;
		
		int horario = Integer.parseInt(ag.getDataServico().substring(11, 13));
		horario++;
		agendamento.setHorarioTermino("" + horario);
		
		System.out.println("\n\n");
		
//		for (Agendamento agendamento : ag) {
//			System.out.println(agendamento);
//		}
		
		agendamentoRepository.save(ag);
		return new ResponseEntity<Agendamento>(ag, HttpStatus.CREATED);
	}

	@PostMapping(value = "/updateUser", produces = { "application/json" }, consumes = "application/json")
	public ResponseEntity<Usuario> updateUser(@RequestBody Usuario usr) {
		usr.setActive(true);
		iusuario.save(usr);
		return new ResponseEntity<Usuario>(usr, HttpStatus.ACCEPTED);
	}

	////////////// Login Apk (Ok) /////////////
	@GetMapping(value = "/login/{email}/{passwd}", produces = "application/json")
	public ResponseEntity<Usuario> doLogin(@PathVariable String email, @PathVariable String passwd) {
		Usuario usuario = new Usuario();
		usuario = iusuario.doLoginQuery(email, passwd);
		
		System.out.println(usuario);
		if (usuario != null) {
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		} else {
			return new ResponseEntity<Usuario>(usuario, HttpStatus.FORBIDDEN);
		}
	}
	
	/////////// SET GET ///////////

	public LoginRepository getLoginRepository() {
		return loginRepository;
	}

	public void setLoginRepository(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

}
