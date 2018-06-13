package com.sp.group.firends.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

@Entity(name = "messages")
public class MessageVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "p_id")
	private long pid;
	
	@Column(name = "text")
	@Length(max = 500, message = "Message text must not be more than 500 characters.")
	private String text;
	
	public MessageVO() {
	}

	public MessageVO(long id, long pid, String text) {
		super();
		this.id = id;
		this.pid = pid;
		this.text = text;
	}
	
	public MessageVO(long pid, String text) {
		this.pid = pid;
		this.text = text;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "MessageVO [id=" + id + ", pid=" + pid + ", text=" + text + "]";
	}
	
	
	
}
