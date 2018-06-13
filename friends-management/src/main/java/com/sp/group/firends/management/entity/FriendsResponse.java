package com.sp.group.firends.management.entity;

import java.util.List;

public class FriendsResponse extends BaseReponse{

	@Override
	public String toString() {
		return "FriendsResponse [friends=" + friends + ", count=" + count + "]";
	}


	private static final long serialVersionUID = 1L;

	private List<String> friends;
	
	private int count;
	
	
	public FriendsResponse() {
		
	}
	
	public FriendsResponse(boolean success, List<String> friends) {
		super(success);
		this.friends = friends;
		this.count = friends.size();
	}


	public List<String> getFriends() {
		return friends;
	}


	public void setFriends(List<String> friends) {
		this.friends = friends;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}

}
