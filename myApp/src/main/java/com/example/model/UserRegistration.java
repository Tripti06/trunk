package com.example.model;

import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserRegistration {

	private String username;
	private String password;
//	private String[] authority;
	private Set<SimpleGrantedAuthority> authority; 

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = "{noop}"+password;
	}

	public Set<SimpleGrantedAuthority> getAuthority() {
		return authority;
	}

	public void setAuthority(Set<SimpleGrantedAuthority> authority) {
		this.authority = authority;
	}

}
