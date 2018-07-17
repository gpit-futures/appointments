package com.answerdigital.appointment.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AppointmentMessageService extends MessageService{

	@Value("${appointment.created.key}")
	private String createdKey;
	
	@Value("${appointment.exchange.key}")
	private String exchangeKey;
	
	@Override
	protected String getCreateKey() {
		// TODO Auto-generated method stub
		return createdKey;
	}

	@Override
	protected String getUpdateKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getExchangeKey() {
		// TODO Auto-generated method stub
		return exchangeKey;
	}

}
