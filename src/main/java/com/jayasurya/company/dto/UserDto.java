package com.jayasurya.company.dto;

import lombok.Data;

@Data
public class UserDto {

	private String uName;

	private String username;
	private String password;
	private String role;
	private String email;
	private String mobile;
	
	public UserDto() {
		super();
	}
}
