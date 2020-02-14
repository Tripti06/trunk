package com.example.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	// Enable jdbc authentication
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("inside configAuthentication for DB authentication");
		auth.jdbcAuthentication().dataSource(dataSource);//.passwordEncoder(passwordEncoder());
	}

	@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager() throws Exception {
		System.out.println("jdbcUserDetailsManager is invoked");
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(dataSource);
		return jdbcUserDetailsManager;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**").and().ignoring().antMatchers("/h2/**");
	}

	// authentication
	/*
	 * Disable inMemory authentication
	 * 
	 * @Override public void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { System.out.println(" configure - AuthenticationManagerBuilder");
	 * 
	 * auth.inMemoryAuthentication().withUser("tripti").password("{noop}tripti").
	 * roles("USER"); }
	 */

	// authorization

	@Override
	public void configure(HttpSecurity http) throws Exception {
		System.out.println(" configure - HttpSecurity");
		http.authorizeRequests().antMatchers("/").permitAll()
				.antMatchers("/test").hasAnyRole("USER", "ADMIN")
				.antMatchers("/getSalary/empId/**").hasAnyRole("ADMIN")
				.antMatchers("/welcome").hasAnyRole("USER", "ADMIN")
				.antMatchers("/login").hasAnyRole("USER", "ADMIN")
				.antMatchers("/register").hasAnyRole("USER", "ADMIN")
				.antMatchers("/getByName/empName/**").hasAnyRole("USER", "ADMIN")
				.antMatchers("/getEmployee/salaryEqAbove/**").hasAnyRole("ADMIN")
				.antMatchers("/getManagerName/empName/**").hasAnyRole("USER", "ADMIN")
				.antMatchers("/getNoOfEmployees/managerName/**").hasAnyRole("ADMIN").anyRequest()
				.authenticated().and().formLogin().loginPage("/login")
				.loginProcessingUrl("/login").permitAll().and().logout().permitAll();

		http.csrf().disable();
	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}



}
