package com.jsobral.project.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jsobral.project.model.ClosedDate;
import com.jsobral.project.model.Hotel;

/**
 * Class used to communicate with the DB, extends the BaseDAO which has the main generic 
 * methods to save/remove objects and the EntityManager. This class implements methods
 * specific to the ClosedDates table with customized search queries.
 * @author joao
 *Copyright 2016, Joao Sobral, All rights reserved.
 */
@Repository
public class ClosedDatesDAO extends BaseDAO{
	
	/**
	 * Used to retrieve the close outs for a hotel/year.
	 * @param hotel that we want to search the close outs for
	 * @param year that we want to search the close outs for
	 * @return a List of ClosedDate, one for each day of the year shows if date closed or not.
	 */
	@Transactional
	public List findByParams(Hotel hotel,int year){
		return (List) super.em.createQuery(
				"SELECT c FROM ClosedDate c "+
				"WHERE c.year LIKE :year "+
				"AND c.hotel LIKE :hotel")
				.setParameter("hotel", hotel)
				.setParameter("year", year)
				.getResultList();
	}
	
	/**
	 * Updates a row in the ClosedDates table that matches the hotel/year/month/day
	 * and updates its closed status, 0 for false or not closed, 1 for true or closed date
	 * @param date the ClosedDate  instance with all the information to match the row 
	 * and closed date status
	 * @return int number of rows updated, only one row should match the query
	 */
	@Transactional
	public int updateClosedDate(ClosedDate date){
		return super.em.createQuery(
				"UPDATE ClosedDate SET closed = :closed" +
			      " WHERE hotel = :hotel"+
			      " AND year = :year"+
			      " AND month = :month"+
			      " AND day = :day")
				.setParameter("closed", date.getClosed())
				.setParameter("hotel", date.getHotel())
				.setParameter("year", date.getYear())
				.setParameter("month", date.getMonth())
				.setParameter("day", date.getDay())
				.executeUpdate();
	}
}
