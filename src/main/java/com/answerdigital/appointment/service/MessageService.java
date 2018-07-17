package com.answerdigital.appointment.service;

import java.util.Map;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import com.answerdigital.appointment.dto.ResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class MessageService<DTO extends ResponseDTO> {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@SuppressWarnings("unchecked")
	public void publishCreateMessage(DTO dto, String odsId) throws JsonProcessingException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Map<String, String> details =  
				(Map<String, String>) ((OAuth2AuthenticationDetails) auth.getDetails()).getDecodedDetails();
		
		MessageProperties properties = new MessageProperties();
		
		properties.setHeader("originOds", details.get("odsId"));
		properties.setHeader("destinationOds", odsId);
		properties.setContentType("application/json");
		
		Message message = MessageBuilder.withBody(
				objectMapper.writeValueAsBytes(dto)).andProperties(properties).build();
		
		this.rabbitTemplate.convertAndSend(getExchangeKey(), getCreateKey(), message);
	}
	
	protected abstract String getCreateKey();
	protected abstract String getUpdateKey();
	protected abstract String getExchangeKey();
}
