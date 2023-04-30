package com.avisys.cim;

import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(JdbcSQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ApiResponse> jdbcSQLIntegrityConstraintViolationExceptionHandler(JdbcSQLIntegrityConstraintViolationException ex){
		ApiResponse apiResponse = new ApiResponse("Mobile unique key constaint violation.. Please enter unique mobile number", false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST); 
	}
	
}
