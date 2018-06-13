package com.sp.group.firends.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "connections")
public class ConnectionsVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="p_id")
	private long pid;
	
	@Column(name="f_id")
	private long fid;
	
	@Column(name="block")
	private boolean block;
	
	public ConnectionsVO(){
		
	}
	
	public ConnectionsVO(long pid, long fid, boolean block){
		this.pid = pid;
		this.fid = fid;
		this.block = block;
	}
	
	public ConnectionsVO(long id, long pid, long fid, boolean block, boolean subscribed){
		super();
		this.id = id;
		this.pid = pid;
		this.fid = fid;
		this.block = block;
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

	public boolean isBlock() {
		return block;
	}

	public void setBlock(boolean block) {
		this.block = block;
	}

	@Override
	public String toString() {
		return "ConnectionsVO [id=" + id + ", pid=" + pid + ", fid=" + fid + ", block=" + block + "]";
	}

	
}
