package com.jsobral.project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jsobral.project.dao.ClosedDatesDAO;
import com.jsobral.project.model.ClosedDate;
import com.jsobral.project.model.Hotel;

@Service
public class ClosedDatesService {
	
	@Autowired
	private ClosedDatesDAO dao;
	
	public List find(int hotelID,int year){
		Hotel hotel = dao.findById(Hotel.class, hotelID);
		return dao.findByParams(hotel, year);
	}
	
	
	public void updateClosedDate(List<ClosedDate> dates,int id){
		Hotel dbhotel = dao.findById(Hotel.class, id);
		for(ClosedDate date:dates){	
			date.setHotel(dbhotel);
			dao.updateClosedDate(date);
		}
	}
}
