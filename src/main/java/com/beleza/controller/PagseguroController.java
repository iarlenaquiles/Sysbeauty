package com.beleza.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beleza.model.Agendamento;
import com.beleza.model.Servico;
import com.beleza.model.Session;

import br.com.uol.pagseguro.api.PagSeguro;
import br.com.uol.pagseguro.api.PagSeguroEnv;
import br.com.uol.pagseguro.api.common.domain.ShippingType;
import br.com.uol.pagseguro.api.common.domain.builder.AddressBuilder;
import br.com.uol.pagseguro.api.common.domain.builder.CreditCardBuilder;
import br.com.uol.pagseguro.api.common.domain.builder.DocumentBuilder;
import br.com.uol.pagseguro.api.common.domain.builder.HolderBuilder;
import br.com.uol.pagseguro.api.common.domain.builder.InstallmentBuilder;
import br.com.uol.pagseguro.api.common.domain.builder.PaymentItemBuilder;
import br.com.uol.pagseguro.api.common.domain.builder.PhoneBuilder;
import br.com.uol.pagseguro.api.common.domain.builder.SenderBuilder;
import br.com.uol.pagseguro.api.common.domain.builder.ShippingBuilder;
import br.com.uol.pagseguro.api.common.domain.enums.Currency;
import br.com.uol.pagseguro.api.common.domain.enums.DocumentType;
import br.com.uol.pagseguro.api.credential.Credential;
import br.com.uol.pagseguro.api.http.JSEHttpClient;
import br.com.uol.pagseguro.api.session.CreatedSession;
import br.com.uol.pagseguro.api.transaction.register.DirectPaymentRegistrationBuilder;
import br.com.uol.pagseguro.api.transaction.search.TransactionDetail;
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

	@PostMapping("/pagseguro/cartao")
	public TransactionDetail CreateDirectPaymentWithCreditCard(@RequestBody Agendamento agendamento) throws ParseException {
		final PagSeguro pagSeguro = PagSeguro.instance(new SimpleLoggerFactory(), new JSEHttpClient(),
				Credential.sellerCredential(email, token), PagSeguroEnv.SANDBOX);

		DirectPaymentRegistrationBuilder dprb = new DirectPaymentRegistrationBuilder();

		for (Servico servico : agendamento.getServico()) {
			dprb.addItem(new PaymentItemBuilder().withId(servico.getId().toString())
					.withDescription(servico.getNome_servico())
					.withAmount(new BigDecimal(servico.getValor())).withQuantity(1));
		}

		TransactionDetail creditCardTransaction = pagSeguro.transactions()
				.register(dprb
						.withPaymentMode("default")
						.withCurrency(Currency.BRL)
						.withNotificationURL("www.sualoja.com.br/notification")
						.withReference(agendamento.getId().toString())
						.withSender(new SenderBuilder()
								.withEmail(agendamento.getCliente().getEmail())
								.withName(agendamento.getCliente().getNome())
								.withCPF(agendamento.getCliente().getCpf())
								.withHash(agendamento.getCliente().getHashComprador())
								.withPhone(new PhoneBuilder()
										.withAreaCode(agendamento.getCliente().getTelefone().substring(0, 2))
										.withNumber(agendamento.getCliente().getTelefone().substring(2))))
						.withShipping(new ShippingBuilder()
								.withType(ShippingType.Type.USER_CHOISE)
								.withCost(new BigDecimal(0))
								.withAddress(new AddressBuilder()
										.withPostalCode(agendamento.getCliente().getCep())
										.withCountry("BRA")
										.withState(agendamento.getCliente().getEstado())
										.withCity(agendamento.getCliente().getCidade())
										.withComplement("")
										.withDistrict("Bairro")
										.withStreet(agendamento.getCliente().getEndereco())
										.withNumber(String.valueOf(agendamento.getCliente().getNumero())))))
				.withCreditCard(new CreditCardBuilder()
						.withBillingAddress(new AddressBuilder()
								.withPostalCode(agendamento.getCliente().getCep())
								.withCountry("BRA")
								.withState(agendamento.getCliente().getEstado())
								.withCity(agendamento.getCliente().getCidade())
								.withComplement("")
								.withDistrict("")
								.withNumber(String.valueOf(agendamento.getCliente().getNumero()))
								.withStreet(agendamento.getCliente().getEndereco()))
						
						.withInstallment(new InstallmentBuilder().withQuantity(1)
								.withValue(new BigDecimal(agendamento.getTotal())))
						
						.withHolder(new HolderBuilder()
								.addDocument(new DocumentBuilder()
										.withType(DocumentType.CPF).withValue(agendamento.getCliente().getCpf()))
								.withName(agendamento.getCliente().getNome())
								.withBithDate(new SimpleDateFormat("dd/MM/yyyy").parse("10/10/1990"))
								.withPhone(new PhoneBuilder()
										.withAreaCode(agendamento.getCliente().getTelefone().substring(0, 2))
										.withNumber(agendamento.getCliente().getTelefone().substring(2))))
						.withToken(agendamento.getCliente().getHashCard()));

		return creditCardTransaction;
	}
}
