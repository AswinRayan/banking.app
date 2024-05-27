package com.project.banking.app.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestControllerAdvice(annotations = { RestController.class })
public class CustomException extends Exception {

	public CustomException() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ExceptionHandler({ CustomException.class })
	public ResponseEntity<Object> handleInvalidException(CustomException ex) {
		ErrResponse errResponse = new ErrResponse();
		errResponse.setErrResponseCode("SW000");
		errResponse.setErrResponseerror(ex.toString());
		return new ResponseEntity<Object>(errResponse, HttpStatus.UNPROCESSABLE_ENTITY);

	}

	@ExceptionHandler({ JsonMappingException.class })
	public ResponseEntity<Object> HandleInvalidRequest(JsonMappingException ex) {
		ErrResponse errResponse = new ErrResponse();
		errResponse.setErrResponseCode("SW0002");
		errResponse.setErrResponseerror(ex.toString());
		return new ResponseEntity<Object>(errResponse, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	@ExceptionHandler({ JsonParseException.class })
	public ResponseEntity<Object> HandleInvalidRequest(JsonParseException ex) {
		ErrResponse errResponse = new ErrResponse();
		errResponse.setErrResponseCode("SW0002");
		errResponse.setErrResponseerror(ex.toString());
		return new ResponseEntity<Object>(errResponse, HttpStatus.UNPROCESSABLE_ENTITY);
	}
}
