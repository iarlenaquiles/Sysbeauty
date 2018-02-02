package br.com.beleza.controller.view;

import java.util.Arrays;
import java.util.HashSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.beleza.Repository.IUsuario;
import br.com.beleza.Repository.LoginRepository;
import br.com.beleza.Repository.RoleRepository;
import br.com.beleza.model.Login;
import br.com.beleza.model.Role;
import br.com.beleza.model.Usuario;

@Controller
@CrossOrigin()
public class UsuarioView {

	@Autowired
	private IUsuario iusuario;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private LoginRepository loginRepository;

	public Usuario usuario = new Usuario();

	@GetMapping(value = "/perfil-cliente")
	public ModelAndView perfil_cliente(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("/perfil-cliente");

		// modelAndView.addObject("usuario", new Usuario());

		return modelAndView;
	}

	///////////// FUNÇÔES PORTAL ////////////////

	////////////////// Cadastro de Cliente (Ok) ///////////
	@PostMapping(value = "/ViewNewuser", produces = { "application/json" })
	public ResponseEntity<Usuario> createUser(Usuario usr) {
		Role userRole = roleRepository.findByRole("USER");
		Login login = new Login();
		login.setActive(true);
		login.setEmail(usr.getEmail());
		login.setSenha(usr.getSenha());
		login.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		loginRepository.save(login);
		usr.setActive(true);
		usr.setLogin(login);
		iusuario.save(usr);
		return new ResponseEntity<Usuario>(usr, HttpStatus.CREATED);
	}

	//////////////// Alterações Cliente //////////////
	@RequestMapping(value = "/salvarAlteracao", method = RequestMethod.POST)
	public ModelAndView salvarAlteracao(@ModelAttribute @Valid Usuario usuarioModel, final BindingResult result,
			Model model, RedirectAttributes redirectAttributes) {

		boolean isErroNullCampos = false;

		/*
		 * AQUI ESTAMOS VERIFICANDO SE TEM ALGUM CAMPO QUE NÃO ESTÁ PREENCHIDO, MENOS O
		 * CAMPO DA SENHA, POIS SE O USUÁRIO NÃO INFORMAR VAMOS MANTER A SENHA JÁ
		 * CADASTRADA
		 */
		for (FieldError fieldError : result.getFieldErrors()) {
			if (!fieldError.getField().equals("senha")) {
				isErroNullCampos = true;
			}
		}

		/*
		 * SE ENCONTROU ERRO DEVEMOS RETORNAR PARA A VIEW PARA QUE O USUÁRIO TERMINE DE
		 * INFORMAR OS DADOS
		 */
		if (isErroNullCampos) {

			/*
			 * ADICIONANDO O OBJETO usuarioModel PARA MOSTRAR NA PÁGINA(VIEW) AS INFORMAÇÕES
			 * DO USUÁRIO
			 */
			model.addAttribute("usuarioModel", usuarioModel);

			/* RETORNANDO A VIEW */
			return new ModelAndView("editarCadastro");
		} else {

			/* SALVANDO AS INFORMAÇÕES ALTERADAS DO USUÁRIO */
			usuarioModel.setActive(true);
			iusuario.save(usuarioModel);

		}

		/* APÓS SALVAR VAMOS REDIRICIONAR O USUÁRIO PARA A PÁGINA DE CONSULTA */
		ModelAndView modelAndView = new ModelAndView("homecliente");

		/* RETORNANDO A VIEW */
		return modelAndView;
	}

	//////////////////// Login manual (teste) /////////////////
	@GetMapping(value = "/login/{email}/{senha}")
	public ResponseEntity<Usuario> doLogin(@PathVariable String email, @PathVariable String senha) {
		System.out.println(email + senha);
		Usuario usuario = new Usuario();
		usuario = iusuario.doLoginQuery(email, senha);
		if (usuario != null) {
			System.out.println("Sim");
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		} else {
			System.out.println("Não");
			return new ResponseEntity<Usuario>(usuario, HttpStatus.FORBIDDEN);
		}
	}

	////////////// Teste ///////////
	@PostMapping("/save")
	public ModelAndView save(@Valid Usuario usuario, BindingResult bindingResult) {
		usuario.setActive(true);
		iusuario.save(usuario);
		return new ModelAndView("/perfil-cliente");
	}

	//////////// GET SET ////////////

	public IUsuario getIusuario() {
		return iusuario;
	}

	public void setIusuario(IUsuario iusuario) {
		this.iusuario = iusuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
