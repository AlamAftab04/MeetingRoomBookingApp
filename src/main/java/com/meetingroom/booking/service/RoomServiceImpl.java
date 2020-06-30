package com.meetingroom.booking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.meetingroom.booking.model.Room;


@Service
public class RoomServiceImpl implements RoomService {

	@Override
	public List<Room> findAll() {
		List <Room> roomList = new ArrayList <Room>();
		Room room1 = new Room("Snow Fall Room", "1");
		Room room2 = new Room("Summer Room", "2");
		Room room3 = new Room("Dark Shed Room", "3");
		Room room4 = new Room("Pink Panther Room", "4");
		Room room5 = new Room("Spring Room", "5");
		Room room6 = new Room("Winter Wall Room", "6");
		roomList.add(room1);
		roomList.add(room2);
		roomList.add(room3);
		roomList.add(room4);
		roomList.add(room5);
		roomList.add(room6);
		return roomList;
	}

}