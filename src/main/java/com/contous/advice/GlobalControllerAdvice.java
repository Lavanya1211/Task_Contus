package com.contous.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.contous.dto.MessageDto;

@ControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MessageDto> exception() {
		return new ResponseEntity<>(new MessageDto("Something went wrong", HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
	}
	
}
