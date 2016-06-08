package com.jsobral.project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jsobral.project.dao.HotelDAO;
import com.jsobral.project.model.Hotel;

@Service
public class HotelService {

	@Autowired
	HotelDAO dao;
	
	public void save(Hotel hotel){
		dao.save(hotel);
	}
	
	public List findByParams(Hotel hotel){
		return dao.findWithParams(hotel);
	}
}
