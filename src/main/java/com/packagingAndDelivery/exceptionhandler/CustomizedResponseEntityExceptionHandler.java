package com.packagingAndDelivery.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



public class CustomizedResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException
	(Exception ex, WebRequest request) throws Exception {
	
		ExceptionResponse ER=new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		
		 return new ResponseEntity<Object>(ER,HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(InvalidInputDetailsException.class)
	public final ResponseEntity<Object> handleInvalidInputDetailsException
	(Exception ex, WebRequest request) throws Exception {
	
		ExceptionResponse ER=new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		
		 return new ResponseEntity<Object>(ER,HttpStatus.BAD_REQUEST);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ExceptionResponse ER=new ExceptionResponse(new Date(),"Validation Failed",ex.getBindingResult().toString());
		
		return new ResponseEntity<Object>(ER,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	
}
