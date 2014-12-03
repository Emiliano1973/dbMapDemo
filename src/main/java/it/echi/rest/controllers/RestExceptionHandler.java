package it.echi.rest.controllers;

import it.echi.services.ServiceException;
import it.echi.services.beans.ErrorMessage;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


	public RestExceptionHandler() {
		// TODO Auto-generated constructor stub
	}
	
	@ExceptionHandler({ServiceException.class, RuntimeException.class})
	public ResponseEntity<Object> handelServiceException(final RuntimeException exception, WebRequest request){
		
		Exception ex=exception;
		ErrorMessage er=new ErrorMessage("500", ex.getMessage());
		HttpHeaders  headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	
		return super.handleExceptionInternal(ex, er, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
	
	

}
