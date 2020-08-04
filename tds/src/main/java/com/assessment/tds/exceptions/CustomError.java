package com.assessment.tds.exceptions;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class CustomError {
 
    private HttpStatus httpStatus;
   private int httpCode;
    private String message;
//    private String path;
//    "timestamp": "2020-08-04T00:17:59.263+00:00",
//    "status": 404,
//    "error": "Not Found",
//    "message": "",
//    "path": "/GET/ba/"
    public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public CustomError(HttpStatus status, String message) {
        super();
        this.httpStatus = status;
        this.message = message;
        this.httpCode=status.value();
    }

	public int getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}
 

}