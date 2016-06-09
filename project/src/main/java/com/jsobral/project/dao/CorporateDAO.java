package com.jsobral.project.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.jsobral.project.model.Corporate;

@Repository
public class CorporateDAO extends BaseDAO{
	
	@Transactional
	public List findByParams(Corporate company){
		return (List) super.em.createQuery(
				"SELECT c FROM Corporate c WHERE c.corporateName LIKE :cName "+
				"AND c.corporateAddress LIKE :cAddress "+
				"AND c.vatNumber LIKE :vat ")
				.setParameter("cName", company.getCorporateName()+"%")
				.setParameter("cAddress", company.getCorporateAddress()+"%")
				.setParameter("vat", company.getVatNumber()+"%")
				.getResultList();
	}

}
