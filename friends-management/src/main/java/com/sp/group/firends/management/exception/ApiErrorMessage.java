package com.sp.group.firends.management.exception;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class ApiErrorMessage {
	private String errorRef;
	private String timestamp;
	private String message;
	private Object details;
	
	public ApiErrorMessage(Date timestamp, String message, Object details) {
	    super();
	    this.errorRef = UUID.randomUUID().toString();
	    this.timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(timestamp);
	    this.message = message;
	    this.details = details;
	}

	public String getErrorRef() {
		return errorRef;
	}

	public void setErrorRef(String errorRef) {
		this.errorRef = errorRef;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getDetails() {
		return details;
	}

	public void setDetails(Object details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ApiErrorMessage [errorRef=" + errorRef + ", timestamp=" + timestamp + ", message=" + message
				+ ", details=" + details + "]";
	}	
}
