package com.example.springboothibernate.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**").and().ignoring().antMatchers("/h2/**");
	}

	// authentication
	  @Override public void configure(AuthenticationManagerBuilder auth) throws
	  Exception { System.out.println(" configure - AuthenticationManagerBuilder");
	  
	  auth.inMemoryAuthentication().withUser("tripti").password("{noop}tripti").
	  roles("USER"); }
	 

	// authorization

	@Override
	public void configure(HttpSecurity http) throws Exception {
		System.out.println(" configure - HttpSecurity");
		http.httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET,"/**").permitAll()
        .antMatchers(HttpMethod.POST,"/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin().permitAll().and().logout().permitAll();
		
		http.csrf().disable();
	}




}
