package com.jsobral.project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jsobral.project.dao.HotelDAO;
import com.jsobral.project.model.Hotel;

/**
 * Provides services associated with hotels like save and find hotel using filters.
 * @author joao
 * Copyright 2016, Joao Sobral, All rights reserved
 */
@Service
public class HotelService {

	@Autowired
	HotelDAO dao;
	
	/**
	 * Invoques dao to create or update hotel in DB.
	 * @param hotel
	 */
	public void save(Hotel hotel){
		dao.save(hotel);
	}
	
	/**
	 * Retrieves hotels from DB based on search criteria
	 * @param hotel Object with search fields like hotel name and/or email
	 * @return list of hotels that match the search fields
	 */
	public List findByParams(Hotel hotel){
		return dao.findWithParams(hotel);
	}
}
