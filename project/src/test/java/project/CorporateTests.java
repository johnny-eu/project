package project;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.jsobral.project.dao.CorporateDAO;
import com.jsobral.project.model.Corporate;
import com.jsobral.project.model.CorporateContact;
import com.jsobral.project.model.Hotel;
import com.jsobral.project.service.CorporateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
public class CorporateTests {
	
	@Autowired
	private CorporateDAO dao;
	
	@Autowired
	private Corporate company;
	
	@Autowired
	private CorporateService service;
	
	@Test
	@Transactional
	public void testInsertAndUpdate(){
		
		//creating corp contact to add to company
		CorporateContact contact = new CorporateContact();
		contact.setContactName("John");
		contact.setContactSurname("Doe");
		CorporateContact savedContact = (CorporateContact) dao.save(contact);
		
		//get hotel object//in app get hotel by id
		Hotel hotel = new Hotel();
		hotel.setHotelAddress("Cork");
		hotel.setHotelName("Awesome Hotel");
		hotel.setStars((short)5);
		Hotel savedHotel = (Hotel)dao.save(hotel);
		
		//creating new corporate to save
		company.setCorporateName("NEW CORP");
		company.setCorporateAddress("Dublin");
		company.setVatNumber("VATN");
		company.setContact(savedContact);
		company.setHotel(savedHotel);
		
		Corporate persistedCorp = (Corporate) dao.save(company);
		
		//Update
		persistedCorp.setVatNumber("NEW_VATN");
		dao.save(persistedCorp);
		
		//Check update worked
		Corporate resultCorp= dao.findById(Corporate.class, persistedCorp.getCorporateId());
		assertEquals("NEW_VATN", resultCorp.getVatNumber());
	}
	
	@Test
	@Transactional
	public void testFilteredGet(){
		//persisting corporate to be returned
		company.setCorporateName("NEW TEST CORP");
		company.setCorporateAddress("Cork");
		company.setVatNumber("NEW TEST");
		dao.save(company);
		
		//preping search  fields object to be sent to find method, only stars is matchable
		Corporate persistedCorp = new Corporate();
		persistedCorp.setCorporateName("");
		persistedCorp.setCorporateAddress("");
		persistedCorp.setVatNumber("NEW T");
		
		List testList = service.findByParams(persistedCorp);
		Corporate corp0 = (Corporate)testList.get(0);
		System.out.println(corp0.getCorporateName()+" "+corp0.getVatNumber());
		assertEquals(testList.size(),1);
		
		
	}
	
}
