package com.answerdigital.appointment.dto;

import java.util.HashMap;
import java.util.Map;

public class Actor {

	private String reference;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}
