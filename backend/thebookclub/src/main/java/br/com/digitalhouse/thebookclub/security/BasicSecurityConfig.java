package br.com.digitalhouse.thebookclub.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);

		auth.inMemoryAuthentication()
			.withUser("root")
			.password(passwordEncoder().encode("root"))
			.authorities("ROLE_USER", "ROLE_ADMIN");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/usuarios/login").permitAll()
			.antMatchers("/usuarios/cadastrar").permitAll()
			.antMatchers("/livros").permitAll()
			.antMatchers("/livros/{id}").permitAll()
			.antMatchers("/livros/titulo/{titulo}").permitAll()
			.antMatchers("/livros/categoria/{categoria}").permitAll()
			.antMatchers("/livros/categorias").permitAll()
			.antMatchers(HttpMethod.OPTIONS).permitAll()
			
			.antMatchers("/usuarios/atualizar").hasAuthority("ROLE_USER")
			.antMatchers("/pedidos/cadastrar").hasAuthority("ROLE_USER")
			
			.antMatchers("/livros/cadastrar").hasAuthority("ROLE_ADMIN")
			.antMatchers("/livros/atualizar").hasAuthority("ROLE_ADMIN")
			
			.anyRequest().authenticated()
			
			.and().httpBasic().and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().cors()
			.and().csrf().disable();
	}
}
