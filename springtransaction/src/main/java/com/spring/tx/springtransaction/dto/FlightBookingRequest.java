package com.spring.tx.springtransaction.dto;

import com.spring.tx.springtransaction.entity.PassengerInfo;
import com.spring.tx.springtransaction.entity.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingRequest {
  private PaymentInfo paymentInfo;
  private PassengerInfo passengerInfo;
}
