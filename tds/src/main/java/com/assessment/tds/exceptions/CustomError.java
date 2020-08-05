package com.assessment.tds.exceptions;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class CustomError {
	private int status;
	private HttpStatus error;
	private String message;

	public HttpStatus getError() {
		return error;
	}

	public CustomError(HttpStatus error, String message) {
		super();
		this.error = error;
		this.status = error.value();
		;
		this.message = message;
	}

	public CustomError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setError(HttpStatus error) {
		this.error = error;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}