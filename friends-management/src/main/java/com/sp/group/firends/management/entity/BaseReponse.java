package com.sp.group.firends.management.entity;

import java.io.Serializable;

/**
 * This is base response with optional attributes.
 * 
 * */
public class BaseReponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private boolean success; 
	
	
	public BaseReponse(boolean success){
		this.success = success;
	}
	
	public BaseReponse(){
		
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "BaseReponse [success=" + success + "]";
	}
	
	
}
