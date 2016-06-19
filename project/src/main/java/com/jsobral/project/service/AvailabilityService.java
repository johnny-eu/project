package com.jsobral.project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jsobral.project.dao.AvailabilityDAO;
import com.jsobral.project.model.Availability;
import com.jsobral.project.model.Hotel;
import com.jsobral.project.model.RoomType;

/**
 * Provides the services associated with Availability like find find update availability
 * @author joao
 * Copyright 2016, Joao Sobral, All rights reserved
 */
@Service
public class AvailabilityService {	
	
	@Autowired
	private AvailabilityDAO dao;
	
	/**
	 * used to find bookings for a specific month/year/room type
	 * @param year, the year of the availability to retrieve
	 * @param month, the month of the availability to retrieve
	 * @param roomID, the room associated with the availability to retrieve
	 * @return List of availability for that month
	 */
	public List findByParams(int year,short month,int roomID){
		RoomType room = dao.findById(RoomType.class, roomID);
		return dao.findByParams(year, month, room);
	}
	
	/**
	 * updates a row of availability based, a day of the year for a given room type updating
	 * its availability,closed status, price and release
	 * @param availability list of availability with days info and details to update for each date.
	 * @param hotelID, the hotel associated with this availability update 
	 */
	public void updateAvailability(List<Availability> availability,int hotelID){
		Hotel hotel = dao.findById(Hotel.class, hotelID);
		for(Availability row:availability){
			row.setHotel(hotel);
			dao.updateAvailability(row);
		}
	}

}
