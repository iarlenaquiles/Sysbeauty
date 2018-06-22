package com.beleza.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beleza.model.Session;

import br.com.uol.pagseguro.api.PagSeguro;
import br.com.uol.pagseguro.api.PagSeguroEnv;
import br.com.uol.pagseguro.api.credential.Credential;
import br.com.uol.pagseguro.api.http.JSEHttpClient;
import br.com.uol.pagseguro.api.session.CreatedSession;
import br.com.uol.pagseguro.api.utils.logging.SimpleLoggerFactory;

@RestController
public class PagseguroController {

	@Value("${pagseguro.email}")
	private String email;

	@Value("${pagseguro.token}")
	private String token;
	
	@GetMapping("/pagseguro/session")
	public Session getSessionId() {
		final PagSeguro pagSeguro = PagSeguro.instance(new SimpleLoggerFactory(), new JSEHttpClient(),
				Credential.sellerCredential(email, token), PagSeguroEnv.SANDBOX);

		try {
			CreatedSession createdSession = pagSeguro.sessions().create();
			Session session = new Session();
			session.setId(createdSession.getId());
			return session;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
