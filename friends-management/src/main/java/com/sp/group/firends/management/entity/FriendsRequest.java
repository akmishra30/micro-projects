package com.sp.group.firends.management.entity;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class FriendsRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Friends should not be empty or null.")
	@Size(min = 2, max = 2, message = "You have to provide two email addresses to find common friends.")
	private List<String> friends;
	
	public FriendsRequest(){
		
	}
	
	public FriendsRequest(List<String> friends){
		this.friends = friends;
	}

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "FriendsRequest [friends=" + friends + "]";
	}

	
	
}
