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
	
	public void publishCreateMessage(DTO dto, String odsId) throws JsonProcessingException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) auth.getDetails();
		Map<String, String> decodedDetails =  (Map<String, String>) details.getDecodedDetails();
		String originOdsId = decodedDetails.get("odsId");
		
		MessageProperties properties = new MessageProperties();
		properties.setHeader("originOds", originOdsId);
		properties.setHeader("destinationOds", odsId);
		
		Message message = MessageBuilder.withBody(objectMapper.writeValueAsBytes(dto)).andProperties(properties).build();
		
		this.rabbitTemplate.convertAndSend(getExchangeKey(), getCreateKey(), message);
	}
	
	protected abstract String getCreateKey();
	protected abstract String getUpdateKey();
	protected abstract String getExchangeKey();
}
