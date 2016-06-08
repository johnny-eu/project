package com.jsobral.project.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BaseDAO{

	@PersistenceContext
	protected EntityManager em;

	@Transactional
	public <T> T findById(Class<T> type,int id){
		return (T) em.find(type,id);
	}
	
	@Transactional
	public Object save(Object object) {
		return em.merge(object);		
	}
	
	@Transactional
	public void remove(Object object){
		em.remove(object);
	}

	@Transactional
	public <T> List<T> getAll(Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

}
