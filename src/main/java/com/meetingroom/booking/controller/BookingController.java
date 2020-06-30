package com.meetingroom.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.meetingroom.booking.model.AvailabilityRequest;
import com.meetingroom.booking.model.AvailabilityResponse;
import com.meetingroom.booking.model.Booking;
import com.meetingroom.booking.model.Room;
import com.meetingroom.booking.service.BookingService;
import com.meetingroom.booking.service.RoomService;

@RestController
@RequestMapping(path = "/bookings")
class BookingController {

	// private Logger log = LoggerFactory.getLogger(BookingController.class);

	@Autowired
	BookingService bookingService;

	@Autowired
	RoomService roomService;

	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Booking> findAll() {
		return bookingService.findAll();
	}

	@GetMapping(value = "/roomNames", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Room> getRoomNames() {
		return roomService.findAll();
	}

	@PostMapping(path = "/bookARoom", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Booking> submitQuestion(@RequestBody Booking booking) {
		bookingService.bookARoom(booking);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping(path = "/isAvailable", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AvailabilityResponse isAvailable(@RequestBody AvailabilityRequest availabilityRequest) {
		return new AvailabilityResponse(bookingService.isAvailable(availabilityRequest));
	}
	
	

}