package br.com.beleza.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import br.com.beleza.Repository.IUsuario;
import br.com.beleza.model.Usuario;

@SessionScope
@RestController(value = "/log")
@CrossOrigin()
public class Log {

	
	@Autowired
	IUsuario iusuario;
	private Usuario userLogado;
	
	@GetMapping(value = "/loginView/{email}/{passwd}", produces = "application/json")
	public ResponseEntity<Usuario> doLogin(@PathVariable String email, @PathVariable String passwd) {
		System.out.println(email + " / " + passwd);
		Usuario usuario = new Usuario();
		usuario = iusuario.doLoginQuery(email, passwd);
		if (usuario != null) {
			userLogado = usuario;	
			logado();
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		} else {
			return new ResponseEntity<Usuario>(usuario, HttpStatus.FORBIDDEN);
		}
	}
	
	@GetMapping(value = "/listUserView", produces = "application/json")
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> usuarios = (List<Usuario>) iusuario.findAll();
		logado();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.ACCEPTED);
	}
	
	
	public void logado() {
		System.out.println(userLogado);
	}

	public Usuario getUserLogado() {
		return userLogado;
	}

	public void setUserLogado(Usuario userLogado) {
		this.userLogado = userLogado;
	}
}
