package com.jsobral.project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jsobral.project.dao.AvailabilityDAO;
import com.jsobral.project.model.Availability;
import com.jsobral.project.model.Hotel;
import com.jsobral.project.model.RoomType;

@Service
public class AvailabilityService {	
	
	@Autowired
	private AvailabilityDAO dao;
	
	public List findByParams(int year,short month,int roomID){
		RoomType room = dao.findById(RoomType.class, roomID);
		return dao.findByParams(year, month, room);
	}
	
	public void updateAvailability(List<Availability> availability,int hotelID){
		Hotel hotel = dao.findById(Hotel.class, hotelID);
		for(Availability row:availability){
			row.setHotel(hotel);
			dao.updateAvailability(row);
		}
	}

}
