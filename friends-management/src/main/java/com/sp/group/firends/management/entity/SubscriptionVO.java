package com.sp.group.firends.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "subscriptions")
public class SubscriptionVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="p_id")
	private long pid;
	
	@Column(name="f_id")
	private long fid;
	
	@Column(name="subscribed")
	private boolean subscribed;
	
	
	public SubscriptionVO(long pid, long fid, boolean subscribed) {
		this.pid = pid;
		this.fid = fid;
		this.subscribed = subscribed;
	}

	
	public SubscriptionVO(long id, long pid, long fid, boolean subscribed) {
		super();
		this.id = id;
		this.pid = pid;
		this.fid = fid;
		this.subscribed = subscribed;
	}


	public SubscriptionVO() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public long getFid() {
		return fid;
	}

	public void setFid(long fid) {
		this.fid = fid;
	}

	public boolean isSubscribed() {
		return subscribed;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	@Override
	public String toString() {
		return "SubscriptionVO [id=" + id + ", pid=" + pid + ", fid=" + fid + ", subscribed=" + subscribed + "]";
	}
}
