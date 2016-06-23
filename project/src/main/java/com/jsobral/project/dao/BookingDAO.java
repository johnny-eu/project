package com.jsobral.project.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.jsobral.project.model.Booking;

/**
 * Class used to communicate with the DB, extends the BaseDAO which has the main generic 
 * methods to save/remove objects and the EntityManager. This class implements methods
 * specific to the Bookings table with customized search queries like retrieve specific bookings
 * and update booking reference.
 * @author joao
 *Copyright 2016, Joao Sobral, All rights reserved.
 */
@Repository
public class BookingDAO extends BaseDAO{

	/**
	 * Get a list of bookings that match some search criteria like arrival date 
	 * or customer surname
	 * @param booking Instance with search criteria
	 * @return List of bookings that match the search criteria
	 */
	@Transactional
	public List findByParams(Booking booking){
		return (List) super.em.createQuery(
				"SELECT b FROM Booking b JOIN FETCH b.customer c "+
				"WHERE b.arrival >= :arrival "+
				"AND b.hotelReference LIKE :hotelReference "+
				"AND c.email LIKE :email "+
				"AND c.surname LIKE :surname "+
				"AND b.hotel = :hotel")
				.setParameter("arrival", booking.getArrival())
				.setParameter("hotelReference", booking.getHotelReference().trim()+"%")
				.setParameter("email", booking.getCustomer().getEmail().trim()+"%")
				.setParameter("surname", booking.getCustomer().getSurname().trim()+"%")
				.setParameter("hotel", booking.getHotel())
				.getResultList();
	}
	
	/**
	 * Used to update the booking hotel reference. as the hotel books the room they get their
	 * own reference number which they have to update in this system. As they do the booking
	 * status changes to confirmed
	 * @param hotelReference, the string to update in the booking
	 * @param bookingId, the id of the booking to update
	 * @return int number of bookings updated by the query, should only return one 
	 */
	@Transactional
	public int updateHotelReference(String hotelReference,int bookingId){
		return super.em.createQuery(
				"UPDATE Booking "+
				  "SET hotelReference = :hotelReference, " +
				  "status = 2 " + //confirmed
			      " WHERE bookingId = :bookingId")
				.setParameter("hotelReference",hotelReference)
				.setParameter("bookingId", bookingId)
				.executeUpdate();
	}
	
}
