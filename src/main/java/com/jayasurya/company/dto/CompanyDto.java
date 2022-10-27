package com.jayasurya.company.dto;

import com.jayasurya.company.entity.User;

import lombok.Data;

@Data
public class CompanyDto {
	
	private int id;
	private String cName;
	private String address;
	private String status;

	private User username;

}
