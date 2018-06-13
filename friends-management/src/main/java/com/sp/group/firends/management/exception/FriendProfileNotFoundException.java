package com.sp.group.firends.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class is the exception class which will be thrown by the service component when 
 * there is no relevant resource available.
 * 
 * @author Ashish Mishra
 * @since 11-06-2018
 * */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class FriendProfileNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	
	private String exception;
	
	public FriendProfileNotFoundException(String exception){
		super(exception);
		this.setException(exception);
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}
}
