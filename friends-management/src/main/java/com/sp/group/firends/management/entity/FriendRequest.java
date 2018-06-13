package com.sp.group.firends.management.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.sp.group.firends.management.validation.ValidationUtil;

public class FriendRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Email should not be empty or null.")
	@Email(regexp = ValidationUtil.EMAIL_REGEX, message = "Invalid email format.")
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Friend [email=" + email + "]";
	}
	
	
}
