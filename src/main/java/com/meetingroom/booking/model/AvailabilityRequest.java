package com.meetingroom.booking.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AvailabilityRequest {

	private String roomName;

	private LocalDateTime fromDate;

	private LocalDateTime toDate;
}