package com.answerdigital.appointment.dto;

import java.util.HashMap;
import java.util.Map;

public class Participant {

	private Actor actor;
	private String status;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}