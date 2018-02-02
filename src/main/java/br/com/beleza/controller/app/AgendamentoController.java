package br.com.beleza.controller.app;

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
import br.com.beleza.model.Agendamento;

@RestController(value = "/agendController")
public class AgendamentoController {

	@Autowired
	private AgendamentoRepository agendamentoRepository;

	
	/*
	 * 0 solicitado agendamento(cliente) 
	 * 1 aprovado(pro.) 
	 * 2 encerrado 
	 * 3 cancelado
	 */
	
	@CrossOrigin
	@PostMapping(value = "/statusAgendamento", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Agendamento> statusAgendamento(@RequestBody Agendamento ag) {			
		agendamentoRepository.save(ag);
		return new ResponseEntity<Agendamento>(ag, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/agAprovacao/{id}", produces = "application/json")
	public ResponseEntity<List<Agendamento>> agAprovacao(@PathVariable Integer id) {
		List<Agendamento> ag = (List<Agendamento>) agendamentoRepository.agAprovacao(id);
		return new ResponseEntity<List<Agendamento>>(ag, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/agHome/{id}", produces = "application/json")
	public ResponseEntity<List<Agendamento>> agHome(@PathVariable Integer id) {
		List<Agendamento> ag = (List<Agendamento>) agendamentoRepository.agHome(id);
		return new ResponseEntity<List<Agendamento>>(ag, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/agPro/{id}", produces = "application/json")
	public ResponseEntity<List<Agendamento>> agPro(@PathVariable Integer id) {
		List<Agendamento> ag = (List<Agendamento>) agendamentoRepository.agPro(id);
		return new ResponseEntity<List<Agendamento>>(ag, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/agEventos/{id}", produces = "application/json")
	public ResponseEntity<List<Agendamento>> agEventos(@PathVariable Integer id) {
		List<Agendamento> ag = (List<Agendamento>) agendamentoRepository.agEventos(id);
		return new ResponseEntity<List<Agendamento>>(ag, HttpStatus.ACCEPTED);
	}
}
