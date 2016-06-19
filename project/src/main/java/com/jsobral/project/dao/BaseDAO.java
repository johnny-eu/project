package com.jsobral.project.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implements the basic JPA mehots to save, update and remove an object as well as to
 * find objects based on their ID. Has an EntityManager to manage the transactions with 
 * the DB.
 * @author joao
 *Copyright 2016, Joao Sobral, All rights reserved.
 */
@Repository
@Transactional
public class BaseDAO{

	@PersistenceContext
	protected EntityManager em;

	/**
	 * Finds an entity by its ID
	 * @param type, java class of the entity we are searching for
	 * @param id of the entity to be returned
	 * @return Object that matches the ID, needs to be casted to specific class
	 */
	@Transactional
	public <T> T findById(Class<T> type,int id){
		return (T) em.find(type,id);
	}
	
	/**
	 * Used to create or update an entity row in the DB.
	 * @param object to be saved. If to update the object passed has to be a persisted object that was retrieved from the DB
	 * @return persisted Object with ID
	 */
	@Transactional
	public Object save(Object object) {
		return em.merge(object);		
	}
	
	/**
	 * Removes an entity from the DB
	 * @param object to be removed, has to be a persisted object retreved from the DB with its ID
	 */
	@Transactional
	public void remove(Object object){
		em.remove(object);
	}

	/**
	 * Retrieves all the rows of a table
	 * @param clazz, the class or entity to retrieve
	 * @return
	 */
	@Transactional
	public <T> List<T> getAll(Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

}
