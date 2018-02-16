package br.com.beleza.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.beleza.Repository.AgendamentoRepository;

@Controller
@CrossOrigin()
public class AgendamentoView {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	
	
}
