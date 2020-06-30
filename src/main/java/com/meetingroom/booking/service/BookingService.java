package com.meetingroom.booking.service;

import java.util.List;

import com.meetingroom.booking.model.AvailabilityRequest;
import com.meetingroom.booking.model.Booking;

public interface BookingService {
	
	List<Booking> findAll();
	
	Booking bookARoom(final Booking booking);

	boolean isAvailable(AvailabilityRequest availabilityReequest);
	
	public Booking cancleBooking(Integer id);
}
