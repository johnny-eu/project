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

	public void save(int year,Hotel hotel){	}
	
	public List find(int year,Hotel hotel){
		
		return null;
	}
	
	public void updateClosedDate(List<ClosedDate> dates,int id){
		Hotel dbhotel = dao.findById(Hotel.class, id);
		System.out.println(dates.size());
		for(ClosedDate date:dates){			
			dao.updateClosedDate(dbhotel, date.getYear(), date.getMonth(), date.getDay(), date.getClosed());
		}
	}
}
