package com.jsobral.project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jsobral.project.dao.ClosedDatesDAO;
import com.jsobral.project.model.ClosedDate;
import com.jsobral.project.model.Hotel;

/**
 * Provides the services associated with Closed Dates like find and update Closed Dates
 * @author joao
 * Copyright 2016, Joao Sobral, All rights reserved
 */
@Service
public class ClosedDatesService {
	
	@Autowired
	private ClosedDatesDAO dao;
	
	/**
	 * used to retrieve close outs for a year/hotel
	 * @param hotelID the hotel for these close outs
	 * @param year the year of close outs to retrieve
	 * @return List of ClosedDates each for a day so a request like this returns a list of
	 *  about 365 ClosedDates instances
	 */
	public List find(int hotelID,int year){
		Hotel hotel = dao.findById(Hotel.class, hotelID);
		return dao.findByParams(hotel, year);
	}
	
	/**
	 * Updates the list previously retrieve and edited on the browser. 
	 * Any changes will be updated in the DB
	 * @param dates List of ClosedDates to update
	 * @param id the hotel Id associated with dates to update
	 */
	public void updateClosedDate(List<ClosedDate> dates,int id){
		Hotel dbhotel = dao.findById(Hotel.class, id);
		for(ClosedDate date:dates){	
			date.setHotel(dbhotel);
			dao.updateClosedDate(date);
		}
	}
}
