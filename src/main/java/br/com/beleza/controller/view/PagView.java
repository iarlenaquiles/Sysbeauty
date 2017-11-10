package br.com.beleza.controller.view;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.beleza.Repository.IUsuario;
import br.com.beleza.model.Usuario;

@Controller
@CrossOrigin()
public class PagView {

	@Autowired
	IUsuario iusuario;

	/////////// Perfil Cliente //////////////
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	///////// DIRECIONAMENTO DE PERFIL /////////////
	@RequestMapping("/default")
	public String defaultAfterLogin(HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		String perfil = iusuario.perfil(email);
		String ADM = "ADMIN";
		String PROF = "PROF";

		if (perfil.equals(ADM)) {
			return "Adm-pages/homeadm";
		} else if (perfil.equals(PROF)) {
			return "prof-pages/home-prof";
		} else {
			return "homecliente";
		}
	}

	@GetMapping(value = "/teste")
	public String perfil() {
		// String nome =
		// SecurityContextHolder.getContext().getAuthentication().getName();
		// System.out.println(nome);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName());
		return "homecliente";
	}

	@RequestMapping(value = "/listUser", method = RequestMethod.GET)
	public ModelAndView listUser(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario usuario = iusuario.listPerfil(auth.getName());
		modelAndView.addObject(usuario);
		model.addAttribute("usuario", usuario);
		modelAndView.setViewName("perfil-cliente");

		return modelAndView;
	}

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String user = auth.getName();
		System.out.println(user);
		return modelAndView;
	}

	@RequestMapping("/cadastro")
	public String cad() {
		return "cadastro";
	}

	@GetMapping("/homecliente")
	public String homecliente() {
		return "homecliente";
	}

	@RequestMapping("/chat")
	public String chat() {
		return "chat";
	}

	@RequestMapping("/sobre")
	public String sobre() {
		return "sobre";
	}

	@RequestMapping("/transacoes")
	public String transacoes() {
		return "transacoes";
	}

	@RequestMapping("/FaleConosco")
	public String FaleConosco() {
		return "FaleConosco";
	}

	@RequestMapping("/ajudahome")
	public String ajudahome() {
		return "ajudahome";
	}

	@RequestMapping("/qualificacao")
	public String qualificacao() {
		return "qualificacao";
	}

	@RequestMapping("/ajuda")
	public String ajuda() {
		return "ajuda";
	}

	/////////// Perfil ADM //////////////

	@GetMapping("/Adm-pages/homeadm")
	public String AdmPagesHomeadm() {
		return "Adm-pages/homeadm";
	}

	/////////// Perfil PROFISSIOANL //////////////

	@GetMapping("/prof-pages/home-prof")
	public String profhome() {
		return "prof-pages/home-prof";
	}
}
