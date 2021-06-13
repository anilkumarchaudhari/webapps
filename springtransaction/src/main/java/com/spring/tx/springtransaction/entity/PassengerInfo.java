package com.spring.tx.springtransaction.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Passenger_Info")
public class PassengerInfo {
	@Id
	@GeneratedValue
	private Long pId;
	private String name;
	private String email;
	private String source;
	private String Destination;
	@JsonFormat(shape = Shape.STRING,pattern = "dd-MM-yyyy")
	private Date travelDate;
	private String pickupTime;
	private String arrivalTime;
	private double fare;
}
