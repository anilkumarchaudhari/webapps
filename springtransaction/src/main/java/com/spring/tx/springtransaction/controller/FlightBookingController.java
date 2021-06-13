package com.spring.tx.springtransaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.tx.springtransaction.dto.FlightBookingAcknowledgement;
import com.spring.tx.springtransaction.dto.FlightBookingRequest;
import com.spring.tx.springtransaction.service.FlightBookingService;

@RestController
public class FlightBookingController {

	@Autowired
	private FlightBookingService flightBookingService;
	
	@RequestMapping(value = "/book/ticket",method = RequestMethod.POST)
	public FlightBookingAcknowledgement  getBookingDetails(@RequestBody FlightBookingRequest request) {
		return flightBookingService.bookFlightTicket(request);
	}
}
