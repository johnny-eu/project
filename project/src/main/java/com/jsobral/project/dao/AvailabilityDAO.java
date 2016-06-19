package com.jsobral.project.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jsobral.project.model.Availability;
import com.jsobral.project.model.RoomType;

/**
 * Class used to communicate with the DB, extends the BaseDAO which has the main generic 
 * methods to save/remove objects and the EntityManager. This class implements methods
 * specific to the Availability table with customized search queries.
 * @author joao
 *Copyright 2016, Joao Sobral, All rights reserved.
 */
@Repository
public class AvailabilityDAO extends BaseDAO{
	
	/**
	 * Searchs for availability for a specific year/month/room type which are the fields selected 
	 * by the user when seraching for a rooms availability. 
	 * @param year, The year the availability applies to
	 * @param month, The month the availability applies to
	 * @param roomType, The room type the availability applies to. These have unique ids and are associated with the hotel they belong to.
	 * @return List of availability objects, each row is a day of the month queried with its availability/price/release.
	 */
	public List findByParams(int year, short month,RoomType roomType){
		return (List) super.em.createQuery(
				"SELECT a FROM Availability a "+
				"WHERE a.year LIKE :year "+
				"AND a.month LIKE :month "+
				"AND a.roomType LIKE :roomType")
				.setParameter("year", year)
				.setParameter("month", month)
				.setParameter("roomType", roomType)
				.getResultList();
	}
	
	/**
	 * Updates a row, its price, availability, release and closed if it matches the room/year/month/day
	 * @param availability contains the Parameters used to match the row to update and fields to 
	 * overwrite in that row.
	 * @return int number of rows updated which should be one only or none.
	 */
	public int updateAvailability(Availability availability){
		return super.em.createQuery(
				"UPDATE Availability " +
				 "SET price = :price, " +
				 "releaseDays = :releaseDays, " +
				 "availableRooms = :availableRooms, " +
				 "closed = :closed " +
			     "WHERE roomType = :roomType "+
			     "AND year = :year "+
			     "AND month = :month "+
			     "AND day = :day")
				.setParameter("price", availability.getPrice())
				.setParameter("releaseDays", availability.getReleaseDays())
				.setParameter("availableRooms", availability.getAvailableRooms())
				.setParameter("closed", availability.getClosed())
				.setParameter("roomType", availability.getRoomType())
				.setParameter("year", availability.getYear())
				.setParameter("month", availability.getMonth())
				.setParameter("day", availability.getDay())
				.executeUpdate();
	}
	
}
