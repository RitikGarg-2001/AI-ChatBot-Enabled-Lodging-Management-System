package com.pgmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pgmanagement.dto.BookPgRoomRequest;
import com.pgmanagement.dto.CommonApiResponse;
import com.pgmanagement.dto.PropertyBookingResponse;
import com.pgmanagement.resource.BookingResource;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/property/booking")
@CrossOrigin(origins = "http://localhost:3000")
public class PropertyBookingController {

	@Autowired
	private BookingResource bookingResource;

	@PostMapping("/add")
	@Operation(summary = "Api to book the pg room")
	public ResponseEntity<CommonApiResponse> bookPgRoom(@RequestBody BookPgRoomRequest request) {
		return this.bookingResource.bookPgRoom(request);
	}

	@PutMapping("/update/status")
	@Operation(summary = "Api to update the property booking status")
	public ResponseEntity<CommonApiResponse> updatePropertyBookingStatus(@RequestParam("bookingId") int bookingId,
			@RequestParam("status") String status) {
		return this.bookingResource.updatePropertyBookingStatus(bookingId, status);
	}

	@GetMapping("/availability/check")
	@Operation(summary = "Api to check the availability of property room")
	public ResponseEntity<CommonApiResponse> checkRoomAvailability(@RequestParam("propertyId") int propertyId,
			@RequestParam("roomId") int roomId, @RequestParam("bedId") int bedId,
			@RequestParam("roomType") String roomType, @RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {
		return this.bookingResource.checkRoomAvailability(propertyId, roomId, bedId, roomType, startDate, endDate);
	}

	@GetMapping("/fetch/status-wise")
	@Operation(summary = "Api to fetch all property bookings status")
	public ResponseEntity<PropertyBookingResponse> fetchAllPropertyBookingByStatus(
			@RequestParam("status") String status) {
		return this.bookingResource.fetchAllPropertyBookingByStatus(status);
	}

	@GetMapping("/fetch/owner-wise")
	@Operation(summary = "Api to fetch all property bookings by owner")
	public ResponseEntity<PropertyBookingResponse> fetchAllPropertyBookingByOwner(
			@RequestParam("ownerId") Integer ownerId, @RequestParam("status") String status) {
		return this.bookingResource.fetchAllPropertyBookingByOwner(ownerId, status);
	}

	@GetMapping("/fetch/guest-wise")
	@Operation(summary = "Api to fetch all property bookings by guest")
	public ResponseEntity<PropertyBookingResponse> fetchAllPropertyBookingByGuest(
			@RequestParam("guestId") Integer guestId, @RequestParam("status") String status) {
		return this.bookingResource.fetchAllPropertyBookingByGuest(guestId, status);
	}

}
