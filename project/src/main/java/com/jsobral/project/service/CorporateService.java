package com.jsobral.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsobral.project.dao.CorporateDAO;
import com.jsobral.project.model.Corporate;

/**
 * Provides services associated with corporate clients like
 * save, find, remove and update corporates
 * @author joao
 * Copyright 2016, Joao Sobral, All rights reserved
 */
@Service
public class CorporateService {

	@Autowired
	private CorporateDAO dao;
	
	/**
	 * calls the dao to create or update a corporate entity
	 * @param company, the entity to create or update
	 */
	public void save(Corporate company){
		dao.save(company);
	}
	
	/**
	 * retrieves list of corporate based on search fields in web form
	 * @param company Object containing search criteria
	 * @return List of corporate that match search fields
	 */
	public List findByParams(Corporate company){
		return dao.findByParams(company);
	}
	
	/**
	 * gets dao to delete a corporate from the DB
	 * @param id, the corporate id for the company to remove
	 */
	@Transactional
	public void remove(int id){
		Corporate company = dao.findById(Corporate.class, id);
		dao.remove(company);
	}
}
