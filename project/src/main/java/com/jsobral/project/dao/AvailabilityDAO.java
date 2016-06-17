package com.jsobral.project.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jsobral.project.model.Availability;
import com.jsobral.project.model.RoomType;

@Repository
public class AvailabilityDAO extends BaseDAO{
	
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
