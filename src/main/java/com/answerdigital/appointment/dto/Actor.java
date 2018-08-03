package com.answerdigital.appointment.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.HashMap;
import java.util.Map;

public class Actor {

	private String reference;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Identifier[] identifier;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String display;

	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}

	public Identifier[] getIdentifier()
	{
		return identifier;
	}
	public void setIdentifier(Identifier[] identifier)
	{
		this.identifier = identifier;
	}

	public String getDisplay()
	{
		return display;
	}
	public void setDisplay(String display)
	{
		this.display = display;
	}
	
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}
