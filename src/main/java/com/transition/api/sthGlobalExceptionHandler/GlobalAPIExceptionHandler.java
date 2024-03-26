package com.transition.api.sthGlobalExceptionHandler;

import java.time.LocalDateTime;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.transition.api.responses.ErrorResponse;

@ControllerAdvice
public class GlobalAPIExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> notFoundException(NotFoundException ex){
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Not Found in DB Check request1.");
		errorResponse.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(errorResponse , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> illegalArgumentException(IllegalArgumentException ex){
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Request contains invalid parameters.");
		errorResponse.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ErrorResponse> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex){
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Not Found in DB.");
		errorResponse.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<ErrorResponse> noResourceFoundException(NoResourceFoundException ex){
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Bad Request Check Url");
		errorResponse.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST);
	}
}
