package com.jsobral.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsobral.project.dao.CorporateDAO;
import com.jsobral.project.model.Corporate;

@Service
public class CorporateService {

	@Autowired
	private CorporateDAO dao;
	
	public void save(Corporate company){
		dao.save(company);
	}
	
	public List findByParams(Corporate company){
		return dao.findByParams(company);
	}
	
	@Transactional
	public void remove(int id){
		Corporate company = dao.findById(Corporate.class, id);
		dao.remove(company);
	}
}
