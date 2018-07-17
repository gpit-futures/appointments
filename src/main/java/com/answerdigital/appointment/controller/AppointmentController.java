package com.answerdigital.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.answerdigital.appointment.dto.Appointment;
import com.answerdigital.appointment.service.MessageService;

@Controller
@RequestMapping("/appointment")
public class AppointmentController{
	
	@Autowired
	private MessageService messageService;
	
	@PostMapping
	@PreAuthorize("hasAuthority('FOO_WRITE')")
	public void create(@RequestBody Appointment appointment) throws Exception {
		messageService.publishCreateMessage(appointment);
	}

}
