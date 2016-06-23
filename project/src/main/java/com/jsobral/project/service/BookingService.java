package com.jsobral.project.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jsobral.project.dao.BookingDAO;
import com.jsobral.project.model.Booking;
import com.jsobral.project.model.Customer;
import com.jsobral.project.model.Hotel;

/**
 * Provides the services associated with Bookings like retrieving list of bookings or 
 * @author joao
 * Copyright 2016, Joao Sobral, All rights reserved
 */
@Service
public class BookingService {
	
	@Autowired
	private BookingDAO dao;
	
	/**
	 * get a list of bookings that match some search criteria like arrival date 
	 * or customer surname
	 * @param booking Instance with search criteria
	 * @return List of bookings that match the search criteria
	 */
	public List findByParams(int hotelId,String arrival,String custEmail,String custSurname,String hotelRef){
		Hotel hotel = dao.findById(Hotel.class, hotelId);
		Booking booking = new Booking();
		booking.setHotel(hotel);
		booking.setArrival(new Date(arrival));
		booking.setCustomer(new Customer());
		booking.getCustomer().setSurname(custSurname);
		booking.getCustomer().setEmail(custEmail);
		booking.setHotelReference(hotelRef);
		return dao.findByParams(booking);
	}
	
	/**
	 * Used to update the booking hotel reference. as the hotel books the room they get their
	 * own reference number which they have to update in this system. As they do the booking
	 * status changes to confirmed
	 * @param hotelReference, the string to update in the booking
	 * @param bookingId, the id of the booking to update
	 * @return the updated booking
	 */
	public void updateHotelReference(String hotelReference, int bookingId){
		dao.updateHotelReference(hotelReference, bookingId);
	} 

}
