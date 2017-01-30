package com.mywork.resumeprocessing.model;

/**
 * @author ManiKanta Kandagatla
 *
 */

public class Mail {

	private String Subject;
	
	private String toAddress;
	
	private String body;
	
	public Mail()
	{
		
	}
	
	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
