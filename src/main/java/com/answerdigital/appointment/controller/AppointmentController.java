package com.answerdigital.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.answerdigital.appointment.dto.Appointment;
import com.answerdigital.appointment.service.AppointmentMessageService;

@Controller
@RequestMapping("/create")
public class AppointmentController{
	
	@Autowired
	private AppointmentMessageService messageService;
	
	@PostMapping
	@PreAuthorize("hasAuthority('FOO_WRITE')")
	@RequestMapping("/{odsId}")
	public void create(@PathVariable String odsId, @RequestBody Appointment appointment) throws Exception {
		messageService.publishCreateMessage(appointment, odsId);
	}

}
