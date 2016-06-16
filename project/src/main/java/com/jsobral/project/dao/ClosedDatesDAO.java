package com.jsobral.project.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.jsobral.project.model.Hotel;

@Repository
public class ClosedDatesDAO extends BaseDAO{
	
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
	
	@Transactional
	public int updateClosedDate(Hotel hotel,int year,short month,short day,short closed){
		return super.em.createQuery(
				"UPDATE ClosedDate SET closed = :closed" +
			      " WHERE hotel = :hotel"+
			      " AND year = :year"+
			      " AND month = :month"+
			      " AND day = :day")
				.setParameter("closed", closed)
				.setParameter("hotel", hotel)
				.setParameter("year", year)
				.setParameter("month", month)
				.setParameter("day", day)
				.executeUpdate();
	}
}
