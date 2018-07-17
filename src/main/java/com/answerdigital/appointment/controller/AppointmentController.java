package com.answerdigital.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.answerdigital.appointment.dto.Appointment;
import com.answerdigital.appointment.service.AppointmentMessageService;

@Controller
@RequestMapping("/create")
public class AppointmentController{
	
	@Autowired
	private AppointmentMessageService messageService;
	
	@PostMapping(path="/{odsId}")
	@PreAuthorize("hasAuthority('FOO_WRITE')")
	@ResponseStatus(value = HttpStatus.OK)
	public void create(@PathVariable String odsId, @RequestBody Appointment appointment) throws Exception {
		messageService.publishCreateMessage(appointment, odsId);
	}

}
