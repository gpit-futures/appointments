package com.answerdigital.appointment.dto;

import java.util.HashMap;
import java.util.Map;

public class Example {

	private Appointment appointment;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
