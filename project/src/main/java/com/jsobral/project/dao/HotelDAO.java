package com.jsobral.project.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jsobral.project.model.Hotel;

/**
 * Class used to communicate with the DB, extends the BaseDAO which has the main generic 
 * methods to save/remove objects and the EntityManager. This class implements methods
 * specific to the Hotels table with customized search queries.
 * @author joao
 *Copyright 2016, Joao Sobral, All rights reserved.
 */
@Repository
public class HotelDAO extends BaseDAO{

	/**
	 * Retrieves Hotels that match serach fields from admin page form. Admin can 
	 * search for hotels by name, address or email.
	 * @param hotel Instance with all the search criteria
	 * @return List of Hotels that match serach fieds or if no fields, it returns all Hotels
	 */
	@Transactional
	public List findWithParams(Hotel hotel){
		return (List) super.em.createQuery(
				"SELECT h FROM Hotel h "+
				"WHERE h.hotelName LIKE :hotelName "+
				"AND h.hotelAddress LIKE :hotelAddress "+
				"AND h.hotelEmail LIKE :hotelEmail "+
				"AND h.stars = :stars"
				)
				.setParameter("hotelName", hotel.getHotelName()+"%")
				.setParameter("hotelAddress", hotel.getHotelAddress()+"%")
				.setParameter("hotelEmail", hotel.getHotelEmail()+"%")
				.setParameter("stars", hotel.getStars())
				.getResultList();
	}
}
