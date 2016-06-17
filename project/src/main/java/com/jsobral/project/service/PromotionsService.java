package com.jsobral.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.jsobral.project.dao.BaseDAO;
import com.jsobral.project.model.Promotion;

@Service
public class PromotionsService {

	@Autowired
	@Qualifier("baseDAO")
	private BaseDAO dao;
	
	
	public Promotion save(Promotion promotion){
		return (Promotion) dao.save(promotion);
	}
	
	public void remove(Promotion promotion){
		dao.remove(promotion);
	}
	
	
}
