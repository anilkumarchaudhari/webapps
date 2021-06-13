package com.spring.tx.springtransaction.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.tx.springtransaction.dto.FlightBookingAcknowledgement;
import com.spring.tx.springtransaction.dto.FlightBookingRequest;
import com.spring.tx.springtransaction.entity.PassengerInfo;
import com.spring.tx.springtransaction.entity.PaymentInfo;
import com.spring.tx.springtransaction.repository.PassengerInfoRepository;
import com.spring.tx.springtransaction.repository.PaymentInfoRepository;
import com.spring.tx.springtransaction.utils.PaymentUtils;

@Service
public class FlightBookingService {

	@Autowired
	PaymentInfoRepository paymentInfoRepository;
	
	@Autowired
	PassengerInfoRepository passengerInfoRepository;
	
//	@Autowired
//	PaymentUtils paymentUtils;
	
	@Transactional //(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
	public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {
		
		PassengerInfo passengerInfo=request.getPassengerInfo();
		passengerInfoRepository.save(passengerInfo);
		
		PaymentInfo paymentInfo = request.getPaymentInfo();
		
		System.out.println("before validate");
		PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
		
		System.out.println("after validate");
		paymentInfo.setPassengerId(passengerInfo.getPId());
		paymentInfo.setAmount(passengerInfo.getFare());
		paymentInfoRepository.save(paymentInfo);
		
		return new FlightBookingAcknowledgement("SUCCESS",
				paymentInfo.getAmount(),UUID.randomUUID().toString().split("-")[0],passengerInfo);	
	}
}
