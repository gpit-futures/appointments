package com.answerdigital.appointment.dto;

public class Message {

	private String system;
	private String source;
	private String destination;
	private ResponseDTO body;
	
	public Message(String system, String source, String destination, ResponseDTO body) {
		this.system = system;
		this.source = source;
		this.destination = destination;
		this.body = body;
	}
	
	public String getSystem() {
		return system;
	}
	
	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public ResponseDTO getBody() {
		return body;
	}
}
