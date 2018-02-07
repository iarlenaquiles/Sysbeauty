package br.com.beleza.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DataSource dataSource;
	
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	System.out.println("Entrou 3");

//    	http.
//		authorizeRequests()
//			.antMatchers("/homecliente").hasRole("USER")
//			.antMatchers("/prof-pages/**").hasRole("PROF")
//			.antMatchers("/Adm-pages/**").hasAnyRole("ADMIN")
//			.antMatchers("/**").permitAll()
//			.anyRequest()
//			.authenticated().and().csrf().disable()
//		.formLogin()
//			.loginPage("/index").failureUrl("/index?error=true")
//			.defaultSuccessUrl("/default")
//			.usernameParameter("usuario_email")
//			.passwordParameter("usuario_senha")
//			.and()
//		.logout()
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//			.logoutSuccessUrl("/index").and().exceptionHandling()
//			.accessDeniedPage("/access-denied");
//    	http
//        .authorizeRequests().anyRequest().authenticated();
//    	
//        http
//        .authorizeRequests()
//        	.antMatchers("/", "/teste", "/homecliente").permitAll()
//			.antMatchers("/homecliente").hasRole("USER")
//			.antMatchers("/prof-pages/**").hasRole("PROF")
//			.antMatchers("/Adm-pages/**").hasAnyRole("ADMIN")
//            .and()
//        .formLogin()
//            .loginPage("/index")
//            .defaultSuccessUrl("/default")
//            .usernameParameter("usuario_email")
//			.passwordParameter("usuario_senha")
//            .permitAll()
//            .and()
//        .logout()
//            .permitAll();
    	
        http
        .authorizeRequests()
		//	.antMatchers("/homecliente").hasRole("USER")
	//		.antMatchers("/prof-pages/**").hasRole("PROF")
//			.antMatchers("/Adm-pages/**").hasAnyRole("ADMIN")
        	.antMatchers("/", "/**").permitAll()
            .anyRequest().authenticated().and().csrf().disable()
        .formLogin()
            .loginPage("/index")
            .defaultSuccessUrl("/default")
            .usernameParameter("login_email")
			.passwordParameter("login_senha")
            .permitAll()
            .and()
        .logout()
            .permitAll();

//        http
//      .authorizeRequests().anyRequest().authenticated();
    }
    
    @Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
    	System.out.println("Entrou 2");

		auth.
			jdbcAuthentication()
				.usersByUsernameQuery(usersQuery)
				.authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource).and()
			.inMemoryAuthentication()
				.withUser("user")
				.password("password")
				.roles("USER");
		
       // auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");

	}
    
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
    
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//    	System.out.println("Entrou 1");
//        auth.
//        inMemoryAuthentication()
//		    .withUser("usuario_email")
//		        .password("usuario_senha")
//		        .roles("role");
//    }
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//	    web
//	       .ignoring()
//	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
//	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String getUsersQuery() {
		return usersQuery;
	}

	public void setUsersQuery(String usersQuery) {
		this.usersQuery = usersQuery;
	}

	public String getRolesQuery() {
		return rolesQuery;
	}

	public void setRolesQuery(String rolesQuery) {
		this.rolesQuery = rolesQuery;
	}
}