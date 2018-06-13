package com.sp.group.firends.management.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * This is subscription entity
 * */
public class Subscription implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "requestor field should not be empty or null.")
	@Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
	private String requestor;
	@NotEmpty(message = "target field should not be empty or null.")
	@Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
	private String target;
	
	public Subscription(){
		
	}
	
	public Subscription(String requestor, String target){
		this.requestor = requestor;
		this.target = target;
	}

	public String getRequestor() {
		return requestor;
	}

	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return "Subscription [requestor=" + requestor + ", target=" + target + "]";
	}
}
