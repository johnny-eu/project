package com.jsobral.project.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jsobral.project.model.Hotel;

@Repository
public class HotelDAO extends BaseDAO{

	@Transactional
	public List findWithParams(Hotel hotel){
		return (List) super.em.createQuery(
				"SELECT h FROM Hotel h WHERE h.hotelName LIKE :hotelName "+
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
