package com.sp.group.firends.management.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UpdateNotification implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "sender field should not be empty or null.")
	@Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
	private String sender;
	@NotEmpty(message = "text field should not be empty or null.")
	private String text;
	
	public UpdateNotification(){
		
	}
	
	public UpdateNotification(String sender, String text){
		this.sender = sender;
		this.text = text;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "UpdateNotification [sender=" + sender + ", text=" + text + "]";
	}
}
