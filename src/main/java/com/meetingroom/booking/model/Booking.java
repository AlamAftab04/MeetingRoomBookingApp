package com.meetingroom.booking.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "BOOKING_TBL")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String roomName;
	
	private String roomId;
	
	private LocalDateTime fromDate;
	
	private LocalDateTime toDate;
	
	private String bookingRef;
	
	private Integer capacity; 
	
	private String creator;
	
	private String email;
	

//	@Override
//	public String toString() {
//		return String.format("Booking[roomName=%s, roomId='%s', from='%s', to='%s', bookingRef='%s', capacity='%s', creator='%s', email='%s']", roomName, roomId, from, to, bookingRef, capacity, creator, email);
//	}
}