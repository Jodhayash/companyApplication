package com.jayasurya.company.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResponseDto implements Serializable{

	private static final long serialVersionUID = -3103934031359382927L;
		
	private boolean error;
		
	private transient Object data;
	
	private String msg;
	
}
