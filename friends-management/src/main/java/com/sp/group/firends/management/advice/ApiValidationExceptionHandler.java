package com.sp.group.firends.management.advice;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sp.group.firends.management.exception.ApiErrorMessage;
import com.sp.group.firends.management.exception.EntityValidationError;
import com.sp.group.firends.management.exception.FieldError;

@ControllerAdvice
public class ApiValidationExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(ApiValidationExceptionHandler.class);
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> errors = bindingResult
                .getFieldErrors()
                .stream()
                .map(fieldError -> new FieldError(fieldError.getField(),
                        fieldError.getCode(),
                        fieldError.getRejectedValue(),
                        fieldError.getDefaultMessage())
                ).collect(Collectors.toList());
		
		EntityValidationError error = new EntityValidationError(errors, bindingResult.getGlobalErrors());
		
		ApiErrorMessage errorDetails = new ApiErrorMessage(new Date(), 
				"Request payload is failed in validation. Please see details.", 
				error);
		
		logger.error("ErrorMessage : ", errorDetails.toString());
		ResponseEntity<Object> entity = new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
		return entity;
	}

	/**
	 * This method catch the marshling related exception and send the generalize API error to consumer.
	 * */
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ApiErrorMessage errorDetails = new ApiErrorMessage(new Date(), 
				"Request payload is empty. Please refer details.", 
				ex.getMessage());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * This method catches the internal exception and send the proper error to consumer.
	 * */
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ApiErrorMessage errorDetails = new ApiErrorMessage(new Date(), 
				"Request payload is empty. Please refer details.", 
				ex.getMessage());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
