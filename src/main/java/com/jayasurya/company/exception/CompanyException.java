package com.jayasurya.company.exception;

public class CompanyException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CompanyException() {
	}

	public CompanyException(String message) {
		super(message);
	}
}
