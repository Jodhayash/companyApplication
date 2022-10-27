package com.jayasurya.company.dto;

import lombok.Data;

@Data
public class UserDto {

	private String name;

	private String username;
	private String password;
	private String role;
	private String email;
	private long mobile;
}
