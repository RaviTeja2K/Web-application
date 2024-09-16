package com.example.demo.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.CustomeException;

@RestControllerAdvice
public class Globalexception {
	
	@ExceptionHandler(CustomeException.class)
	public ResponseEntity<?> exception(CustomeException e) {
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}

}
