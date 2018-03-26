package com.makhir.springboot.katharsis.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/application")
public class RestService {
	private static final Logger log = LoggerFactory.getLogger(RestService.class);
	
	@RequestMapping(value = "/health", method = RequestMethod.GET)
	public ResponseEntity<?> applicationCheck() {
		log.debug("Enter: RestService.applicationCheck");

		ResponseEntity responseEntity = null;

		responseEntity = new ResponseEntity("Application up and running..!!!", new HttpHeaders(), HttpStatus.OK);

		log.debug("Exit: RestService.applicationCheck");

		return responseEntity;
	}
}
