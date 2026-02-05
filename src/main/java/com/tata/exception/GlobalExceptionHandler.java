package com.tata.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

import com.tata.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex,
			WebRequest request) {
		
		ApiResponse response = new ApiResponse(
				LocalDateTime.now(),
				ex.getMessage(),
				false,
				request.getDescription(false)
				);
		
		//ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
				//request.getDescription(false));
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<ApiResponse> handleValidationErrors(
	            MethodArgumentNotValidException ex,
	            WebRequest request) {

	        Map<String, String> errors = new HashMap<>();
	        ex.getBindingResult().getAllErrors().forEach(error -> {
	            String field = ((FieldError) error).getField();
	            String msg = error.getDefaultMessage();
	            errors.put(field, msg);
	        });

	        ApiResponse response = new ApiResponse(
	                LocalDateTime.now(),
	                "Validation failed",
	                false,
	                errors
	        );

	        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	    }

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse> handleGlobalException(Exception ex, WebRequest request) {
		
		ApiResponse response = new ApiResponse(
				LocalDateTime.now(),
				ex.getMessage(),
				false,
				request.getDescription(false)
				);
		
		//ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
				//request.getDescription(false));
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
