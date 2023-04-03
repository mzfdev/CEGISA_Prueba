package com.mjzf.bloggers.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserInfo {
	@NotBlank
	@Size(min = 4, max = 32)
	private String username;
	
	@NotBlank
	private String email;
	
	@NotBlank
	@Size(min = 4, max = 50)
	private String name;
	
	@NotBlank
	@Size(min = 8, max = 32)
	private String password;

	public UserInfo() {
		super();
	}

	public UserInfo(@NotBlank @Size(min = 4, max = 32) String username,
			@NotBlank String email,
			@NotBlank @Size(min = 4, max = 50) String name,
			@NotBlank @Size(min = 8, max = 32) String password) {
		super();
		this.username = username;
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
