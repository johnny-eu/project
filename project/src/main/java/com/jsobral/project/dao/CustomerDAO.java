package com.jsobral.project.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.jsobral.project.model.Customer;

@Repository
public class CustomerDAO {

	@PersistenceContext
	private EntityManager em;	
	
	private Customer customer;
	
	@Transactional
	public Customer save(Customer customer){
		this.customer = em.merge(customer);
		return this.customer;
	}
	
	
}
