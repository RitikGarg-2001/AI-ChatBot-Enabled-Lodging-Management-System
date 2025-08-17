package com.pgmanagement.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class BookingPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "booking_id")
	private PropertyBooking booking;

	private String paymentId; // use this as order id in pg transaction

	private String forMonth;

	private BigDecimal amountPaid;

	private String status;

	private String paymentType; // Wallet

	private String paymentTime;

}
