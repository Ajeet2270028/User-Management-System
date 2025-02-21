package com.example.ums.util;

import org.springframework.http.HttpStatus;

public class ErrorStructure {
  
	private int status;
	private String message;
	private String rootCause;
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
	public String getRootCause() {
		return rootCause;
	}
	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}
	
	public static ErrorStructure create(int status,String message,String rootcause) {
//		ErrorStructure error=new ErrorStructure();
//    	error.setStatus(HttpStatus.NOT_FOUND.value());
//    	error.setMessage(ex.getMessage());
//    	error.setRootCause("user not found for the given id");
//    	return error;
		ErrorStructure error=new ErrorStructure();
    	error.setStatus(status);
    	error.setMessage(message);
    	error.setRootCause(rootcause);
    	return error;
	}
}
