package com.packagingAndDelivery.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidInputDetailsException extends RuntimeException {

	public InvalidInputDetailsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
