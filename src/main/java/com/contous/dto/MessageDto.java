package com.contous.dto;

import org.springframework.http.HttpStatus;

public class MessageDto {

	private String message;
	private HttpStatus errorCode;
	
	public MessageDto(String message, HttpStatus errorCode) {
		super();
		this.message = message;
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}
}
