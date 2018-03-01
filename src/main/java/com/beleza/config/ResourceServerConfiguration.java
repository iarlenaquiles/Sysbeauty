package com.beleza.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(ResourceServerSecurityConfigurer resource) {
		resource.resourceId("restservice");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.logout().logoutUrl("/oauth/logout").invalidateHttpSession(true).clearAuthentication(true).and()
				.authorizeRequests().antMatchers("/clientes/**").hasRole("CLIENTE").antMatchers("/profissionais/**")
				.hasRole("PROFISSIONAL").antMatchers("/portal/**").hasRole("MODERADOR").anyRequest().permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll();
	}
}
