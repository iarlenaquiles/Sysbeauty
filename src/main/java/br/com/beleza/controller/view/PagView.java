package br.com.beleza.controller.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.beleza.Repository.FaleConoscoRepository;
import br.com.beleza.Repository.IUsuario;
import br.com.beleza.Repository.ProfissionalRepository;
import br.com.beleza.model.FaleConosco;
import br.com.beleza.model.Profissional;
import br.com.beleza.model.Usuario;

@Controller
@CrossOrigin()
public class PagView {

	@Autowired
	IUsuario iusuario;

	@Autowired
	ProfissionalRepository profissionalRepository;

	@Autowired
	Log log;

	@Autowired
	private FaleConoscoRepository faleconoscoRepository;
	

	/////////// Perfil Cliente //////////////
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("faleConosco", new FaleConosco());
		return "index";
	}

	///////// DIRECIONAMENTO DE PERFIL /////////////
	@RequestMapping(value="/default", method = RequestMethod.GET)
	public String defaultAfterLogin(HttpServletRequest request, HttpSession session, Model model) {
		String email = request.getUserPrincipal().getName();
		String perfil = iusuario.perfil(email);
		String ADM = "ADMIN";
		String PROF = "PROF";

		session.setAttribute("usuarioLogado", email);
		
		if (perfil.equals(ADM)) {
			model.addAttribute("faleConosco", new FaleConosco());
			return "Adm-pages/homeadm";
		} else if (perfil.equals(PROF)) {
			model.addAttribute("faleConosco", new FaleConosco());
			return "prof-pages/home-prof";
		} else {
			model.addAttribute("faleConosco", new FaleConosco());
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
		model.addAttribute("faleConosco", new FaleConosco());
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

	@RequestMapping(value="/cadastro", method = RequestMethod.GET)
	public String cad(Model model) {
		model.addAttribute("faleConosco", new FaleConosco());
		return "cadastro";
	}

	@RequestMapping(value="/homecliente", method = RequestMethod.GET)
	public String homecliente(Model model) {
		model.addAttribute("faleConosco", new FaleConosco());
		return "homecliente";
	}

	@RequestMapping(value="/chat", method = RequestMethod.GET)
	public String chat(Model model) {
		model.addAttribute("faleConosco", new FaleConosco());
		return "chat";
	}

	@RequestMapping(value="/sobre", method = RequestMethod.GET)
	public String sobre(Model model) {
		model.addAttribute("faleConosco", new FaleConosco());
		return "sobre";
	}

	@RequestMapping(value="/transacoes", method = RequestMethod.GET)
	public String transacoes(Model model) {
		model.addAttribute("faleConosco", new FaleConosco());
		return "transacoes";
	}

	@RequestMapping("/FaleConosco")
	public String FaleConosco() {
		return "FaleConosco";
	}

	@PostMapping("/FaleConosco")
	public String save(@Valid FaleConosco faleConosco, BindingResult bindingResult) {
		
		faleconoscoRepository.save(faleConosco);
		return "index";
	}

	@RequestMapping("/ajudahome")
	public String ajudahome(Model model) {
		model.addAttribute("faleConosco", new FaleConosco());
		return "ajudahome";
	}

	@RequestMapping("/qualificacao")
	public String qualificacao(Model model) {
		model.addAttribute("faleConosco", new FaleConosco());
		return "qualificacao";
	}

	@RequestMapping("/ajuda")
	public String ajuda(Model model) {
		model.addAttribute("faleConosco", new FaleConosco());
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

	@GetMapping("/prof-pages/perfil-prof")
	public String perfilProf() {
		return "/prof-pages/perfil-prof";
	}

	@PostMapping("/prof-pages/perfil-prof")
	public ResponseEntity<Profissional> perfilProfCarregar(HttpSession session) {

		Profissional profissional = profissionalRepository
				.perfilPorEmail(session.getAttribute("usuarioLogado").toString());

		System.out.println(session.getAttribute("usuarioLogado"));
		return new ResponseEntity<Profissional>(profissional, HttpStatus.OK);
	}

	@PostMapping(value = "/alterarProfissional", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Profissional> alterarProfissional(@RequestBody Profissional profissional) {

		profissionalRepository.save(profissional);

		return new ResponseEntity<Profissional>(profissional, HttpStatus.OK);
	}
}
