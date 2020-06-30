package com.meetingroom.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meetingroom.booking.model.AvailabilityRequest;
import com.meetingroom.booking.model.Booking;
import com.meetingroom.booking.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	protected  BookingRepository bookingRepository;
	//protected final MongoClient client;

//	@Autowired
//	public BookingServiceImpl(final BookingRepository bookingRepository, MongoClient client) {
//		this.bookingRepository = bookingRepository;
//		this.client = client;
//	}

	@Override
	public List<Booking> findAll() {
		return bookingRepository.findAll();
	}

	@Override
	public Booking bookARoom(final Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public boolean isAvailable(AvailabilityRequest availabilityRequest) {
		List<Booking> allBookings = bookingRepository.findAll();
		return !allBookings.stream().filter(booking -> booking.getRoomName().equals(availabilityRequest.getRoomName()))
			.filter(booking -> booking.getFromDate().isAfter(availabilityRequest.getToDate()))
				.filter(booking -> booking.getToDate().isBefore(availabilityRequest.getFromDate())).findAny().isPresent();
	}
	
	@Override
	public Booking cancleBooking(Integer id) {
		Optional<Booking> optional = bookingRepository.findById(id);
		Booking booking = null;
		if(optional.isPresent()) {
			bookingRepository.deleteById(id);
			booking =optional.get();
		}
		return booking;
		
	}

}