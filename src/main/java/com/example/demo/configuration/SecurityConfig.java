package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.student.UserPrincipalDetailsService;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private UserPrincipalDetailsService userPrincipalDetailsService;
	public SecurityConfig(UserPrincipalDetailsService userPrincipalDetailsService) {
		this.userPrincipalDetailsService=userPrincipalDetailsService;
	}
	
	
	
	@Autowired
	public void configureGlo(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication()
		.withUser("daly")
		.password(passwordEncoder().encode("daly"))
		.roles("ADMIN");*/
		auth.authenticationProvider(daoAuthProvider());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/getall").hasRole("ADMIN")
				.antMatchers("/").hasRole("Admin")
				.and()
				.formLogin()
				//.successForwardUrl("/")
				.permitAll();
	}
	

	@Bean
	DaoAuthenticationProvider daoAuthProvider() {
		DaoAuthenticationProvider daoAuProv=new DaoAuthenticationProvider();
		daoAuProv.setPasswordEncoder(passwordEncoder());
		daoAuProv.setUserDetailsService(this.userPrincipalDetailsService);
		return daoAuProv;
	}

	
	@Bean
	PasswordEncoder passwordEncoder() {
	     return new BCryptPasswordEncoder();	
	 }
}
