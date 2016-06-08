package com.jsobral.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.jsobral.project.dao.BaseDAO;
import com.jsobral.project.model.PromoPrice;

@Service
public class PromoPriceService {

	@Autowired
	@Qualifier("baseDAO")
	BaseDAO dao;
	
	public void save(PromoPrice promoPrice){
		//do checks
		dao.save(promoPrice);
	}
	
	public void remove(PromoPrice promoPrice){
		dao.remove(promoPrice);
	}
	
	
	
}
