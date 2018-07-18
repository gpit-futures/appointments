package com.answerdigital.appointment.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Appointment extends ResponseDTO {

	private String status;
	private AppointmentType appointmentType;
	private String start;
	private String end;
	private List<Slot> slot = null;
	private List<Participant> participant = null;
	private String description;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public AppointmentType getAppointmentType() {
		return appointmentType;
	}
	public void setAppointmentType(AppointmentType appointmentType) {
		this.appointmentType = appointmentType;
	}

	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}

	public List<Slot> getSlot() {
		return slot;
	}
	public void setSlot(List<Slot> slot) {
		this.slot = slot;
	}

	public List<Participant> getParticipant() {
		return participant;
	}
	public void setParticipant(List<Participant> participant) {
		this.participant = participant;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
