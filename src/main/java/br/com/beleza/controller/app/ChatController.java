package br.com.beleza.controller.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.beleza.Repository.ConversaRepository;
import br.com.beleza.Repository.MensagemRepository;
import br.com.beleza.model.Conversa;
import br.com.beleza.model.Mensagem;

@RestController(value = "/chatController")
public class ChatController {
	
	@Autowired
	private ConversaRepository conversaRepository;
	
	@Autowired	
	private MensagemRepository mensagemRepository;
	
	@PostMapping(value = "/verificaConversa", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Conversa> verificaConversa(@RequestBody Conversa conversa) {
		
		Conversa retorno;
		retorno = conversaRepository.verificarConversa(conversa.getProfissional().getId(), conversa.getUsuario().getId());
		
		if(retorno == null){
			conversaRepository.save(conversa);
			retorno = conversaRepository.verificarConversa(conversa.getProfissional().getId(), conversa.getUsuario().getId());
		}
		
		return new ResponseEntity<Conversa>(retorno, HttpStatus.OK);
	}
	
	@PostMapping(value = "/msgEnviar", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Mensagem> salvarMensagem(@RequestBody Mensagem mensagem) {
		
		mensagem.setData(new Date(System.currentTimeMillis()));
		
		mensagemRepository.save(mensagem);
		
		return new ResponseEntity<Mensagem>(mensagem, HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "/msgCarregar", produces = "application/json", consumes = "application/json")
	public ResponseEntity<List<Mensagem>> listarMensagens(@RequestBody Conversa conversa) {
		
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		
		mensagens = mensagemRepository.listaMensagens(conversa.getId());
		
		return new ResponseEntity<List<Mensagem>>(mensagens, HttpStatus.OK);
	}
	
}
