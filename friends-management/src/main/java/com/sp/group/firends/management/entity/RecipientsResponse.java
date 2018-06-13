package com.sp.group.firends.management.entity;

import java.util.List;

public class RecipientsResponse extends BaseReponse{
	
	private static final long serialVersionUID = 1L;
	
	private List<String> recipients;

	public RecipientsResponse() {
		
	}
	
	public RecipientsResponse(boolean success, List<String> recipients) {
		super(success);
		this.recipients = recipients;
	}

	public List<String> getRecipients() {
		return recipients;
	}

	public void setRecipients(List<String> recipients) {
		this.recipients = recipients;
	}

	@Override
	public String toString() {
		return "RecipientsResponse [recipients=" + recipients + "]";
	}
	
	
}
