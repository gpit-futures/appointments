package com.answerdigital.appointment.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.answerdigital.appointment.dto.Appointment;
import com.answerdigital.appointment.dto.ResponseDTO;



public abstract class MessageService<DTO extends ResponseDTO> {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void publishCreateMessage(Appointment dto) {
		this.rabbitTemplate.convertAndSend(getExchangeKey(), getCreateKey(), dto);
	}
	
	public void publishUpdateMessage(DTO dto) {
		this.rabbitTemplate.convertAndSend(getExchangeKey(), getUpdateKey(), dto);
	}
	
	protected abstract String getCreateKey();
	protected abstract String getUpdateKey();
	protected abstract String getExchangeKey();
}
