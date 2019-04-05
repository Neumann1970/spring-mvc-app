package com.project.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.exception.ResourceNotFoundException;

@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	private String str;
	
	 public CustomResponseEntityExceptionHandler() {
	        super();
	    }
	 
	 public CustomResponseEntityExceptionHandler(String str) {
		 this.str = str;
		 
	 }
	 
	 
	    @ExceptionHandler(value = { ResourceNotFoundException.class })
	    protected ResponseEntity<Object> handleNotFound(final RuntimeException ex, final WebRequest request) {      
	    	
	    	HttpHeaders headers = new HttpHeaders();
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
	       
			return handleExceptionInternal(ex, str, headers, status, request);
	    }


}
