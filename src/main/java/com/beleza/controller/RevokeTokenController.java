package com.beleza.controller;

import javax.annotation.Resource;

import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RevokeTokenController {
	@Resource(name="tokenServices")
	ConsumerTokenServices tokenServices;
	     
	@PostMapping("/logout/{tokenId:.*}")
	public void revokeToken(@PathVariable String tokenId) {
	    tokenServices.revokeToken(tokenId);
	}
}
