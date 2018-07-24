package com.answerdigital.appointment.service;

import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import com.answerdigital.appointment.dto.Message;
import com.answerdigital.appointment.dto.ResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class MessageService<DTO extends ResponseDTO> {

	@Value("${application.name}")
	private String applicationName;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@SuppressWarnings("unchecked")
	public void publishCreateMessage(DTO dto, String odsId) throws JsonProcessingException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Map<String, String> details =  
				(Map<String, String>) ((OAuth2AuthenticationDetails) auth.getDetails()).getDecodedDetails();
		
		this.rabbitTemplate.convertAndSend(
				getExchangeKey(), getCreateKey(), 
				new Message(applicationName, details.get("odsId"), odsId, dto));
	}
	
	protected abstract String getCreateKey();
	protected abstract String getUpdateKey();
	protected abstract String getExchangeKey();
}
