package com.jsobral.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.jsobral.project.dao.BaseDAO;
import com.jsobral.project.model.PromoPrice;

/**
 * Provides services associated with promo prices like save and remove
 * @author joao
 * Copyright 2016, Joao Sobral, All rights reserved
 */
@Service
public class PromoPriceService {

	@Autowired
	@Qualifier("baseDAO")
	BaseDAO dao;
	
	/***
	 * Calls the dao to create or update a promo price
	 * @param promoPrice, Object to create or update in DB
	 */
	public void save(PromoPrice promoPrice){
		//do checks
		dao.save(promoPrice);
	}
	
	/**
	 * Uses the dao to remove an entity from the DB
	 * @param promoPrice, the promo price to remove
	 */
	public void remove(PromoPrice promoPrice){
		dao.remove(promoPrice);
	}
	
}
