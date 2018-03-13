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
				.authorizeRequests().antMatchers("/clientes/**").hasAnyRole("CLIENTE", "PROFISSIONAL", "MODERADOR")
				.antMatchers("/profissionais/**").hasAnyRole("PROFISSIONAL", "CLIENTE", "MODERADOR")
				.antMatchers("/agendamentos/**").hasAnyRole("PROFISSIONAL", "CLIENTE", "MODERADOR")
				.antMatchers("/ajudas/**").hasAnyRole("PROFISSIONAL", "CLIENTE", "MODERADOR").antMatchers("/banners/**")
				.hasAnyRole("PROFISSIONAL", "CLIENTE", "MODERADOR").antMatchers("/cancelamentos/**")
				.hasAnyRole("PROFISSIONAL", "CLIENTE").antMatchers("/comprapacote/**")
				.hasAnyRole("PROFISSIONAL", "CLIENTE").antMatchers("/moderadores/**").hasRole("MODERADOR")
				.antMatchers("/notificacoes/**").hasAnyRole("PROFISSIONAL", "CLIENTE").antMatchers("/pacotes/**")
				.hasRole("PROFISSIONAL").antMatchers("/planos/**").hasAnyRole("PROFISSIONAL", "MODERADOR")
				.antMatchers("/portfolios/**").hasRole("PROFISSIONAL").antMatchers("/promocoes/**")
				.hasAnyRole("PROFISSIONAL", "MODERADOR").antMatchers("/qualificacoes/**")
				.hasAnyRole("PROFISSIONAL", "CLIENTE", "MODERADOR").antMatchers("/selos/**").hasRole("PROFISSIONAL")
				.antMatchers("/servicos/**").hasAnyRole("PROFISSIONAL", "CLIENTE", "MODERADOR")
				.antMatchers("/usuarios/**").hasAnyRole("PROFISSIONAL", "CLIENTE", "MODERADOR")
				.antMatchers("/portal/**").hasRole("MODERADOR").anyRequest().permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().antMatchers("/faleconosco/").permitAll();
	}
}
