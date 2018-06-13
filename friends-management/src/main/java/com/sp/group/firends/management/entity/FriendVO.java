package com.sp.group.firends.management.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "friends")
public class FriendVO{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String email;
	
	public FriendVO(){
		
	}
	
	public FriendVO(long id, String email) {
		super();
		this.id = id;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "connections", joinColumns = @JoinColumn(name = "p_id"),
	inverseJoinColumns = @JoinColumn(name = "f_id"))
	private Set<FriendVO> connections = new HashSet<FriendVO>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "subscriptions", joinColumns = @JoinColumn(name = "p_id"),
	inverseJoinColumns = @JoinColumn(name = "f_id"))
	private Set<FriendVO> subscribers = new HashSet<FriendVO>();
	
	public boolean hasConnections(FriendVO vo){
		return connections.contains(vo);
	}
	
	public void removeConnection(FriendVO vo){
		connections.remove(vo);
	}
	
	public void addConnections(FriendVO vo){
		connections.add(vo);
	}
	
	public Set<FriendVO> getConnections() {
		return connections;
	}

	public void setConnections(Set<FriendVO> connections) {
		this.connections = connections;
	}

	public Set<FriendVO> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(Set<FriendVO> subscriptions) {
		this.subscribers = subscriptions;
	}

	@Override
	public String toString() {
		return "FriendVO [id=" + id + ", email=" + email + "]";
	}
	
}
