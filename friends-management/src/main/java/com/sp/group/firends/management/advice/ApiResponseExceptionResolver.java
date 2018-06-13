package com.sp.group.firends.management.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;

@ControllerAdvice
public class ApiResponseExceptionResolver extends ResponseStatusExceptionResolver{
	private static final Logger logger = LoggerFactory.getLogger(ApiResponseExceptionResolver.class);
	
	
	
}
