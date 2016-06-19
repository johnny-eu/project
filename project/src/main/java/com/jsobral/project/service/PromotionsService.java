package com.jsobral.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.jsobral.project.dao.BaseDAO;
import com.jsobral.project.model.Promotion;

/**
 * Provides services associated with promotions like create, update and remove
 * @author joao
 * Copyright 2016, Joao Sobral, All rights reserved
 */
@Service
public class PromotionsService {

	@Autowired
	@Qualifier("baseDAO")
	private BaseDAO dao;
	
	/**
	 * uses the dao to create or update a promotion
	 * @param promotion, the object to create/update in the DB
	 * @return
	 */
	public Promotion save(Promotion promotion){
		return (Promotion) dao.save(promotion);
	}
	
	/**
	 * calls the dao to remove a promotion
	 * @param promotion, the promotion to delete from the DB
	 */
	public void remove(Promotion promotion){
		dao.remove(promotion);
	}
	
	
}
