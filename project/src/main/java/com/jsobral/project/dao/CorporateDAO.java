package com.jsobral.project.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.jsobral.project.model.Corporate;

/**
 * Class used to communicate with the DB, extends the BaseDAO which has the main generic 
 * methods to save/remove objects and the EntityManager. This class implements methods
 * specific to the Corporates table with customized search queries.
 * @author joao
 *Copyright 2016, Joao Sobral, All rights reserved.
 */
@Repository
public class CorporateDAO extends BaseDAO{
	
	/**
	 * Used to retrieve corporates that match the search fields in the form.
	 * If the fields are left bank then the % char matches everything in the column
	 * @param company, the Company instance with search fields and the hotel
	 * @return List of Corporate that match the search fields, if no fields, it returns all 
	 * the Corporate for that Hotel
	 */
	@Transactional
	public List findByParams(Corporate company){
		return (List) super.em.createQuery(
				"SELECT c FROM Corporate c "+
				"WHERE c.corporateName LIKE :cName "+
				"AND c.corporateAddress LIKE :cAddress "+
				"AND c.vatNumber LIKE :vat "+
				"AND c.hotel LIKE :hotel ")
				.setParameter("cName", company.getCorporateName().trim()+"%")
				.setParameter("cAddress", company.getCorporateAddress().trim()+"%")
				.setParameter("vat", company.getVatNumber().trim()+"%")
				.setParameter("hotel", company.getHotel())
				.getResultList();
	}

}
