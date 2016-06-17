package project;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.jsobral.project.dao.ClosedDatesDAO;
import com.jsobral.project.model.ClosedDate;
import com.jsobral.project.model.Hotel;
import com.jsobral.project.service.ClosedDatesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class ClosedDatesTests {

	@Autowired
	private ClosedDatesDAO dao;
	
	@Autowired
	private ClosedDate date;
	
	@Autowired
	private Hotel hotel;
	
	@Autowired
	private ClosedDatesService service;
	
	
	
	@Test
	@Transactional
	public void testInsertAndFetch(){
		hotel.setHotelName("Test Hotel");
		Hotel persistedHotel = (Hotel) dao.save(hotel);
		
		date.setHotel(persistedHotel);
		date.setClosed((short)1);
		date.setYear(2016);
		date.setMonth((short)10);
		date.setDay((short)3);
		
		dao.save(date);
		
		List closedDates = (List) dao.findByParams(persistedHotel, 2016);
		int numRetrievedDates = closedDates.size();
		System.out.println(numRetrievedDates);
	}
		
	
	@Test
	@Transactional
	public void testService(){
		//setting the hotel for the closed dates
		hotel.setHotelName("Test Service Hotel");
		Hotel persistedHotel = (Hotel) dao.save(hotel);
	
		//setting the closed dates list
		List<ClosedDate> dates = new ArrayList<>();
		
		//adding closed dates to db 
		dao.save(new ClosedDate(2016,(short)10,(short)1,(short)0,persistedHotel));
		dao.save(new ClosedDate(2016,(short)10,(short)2,(short)0,persistedHotel));
		dao.save(new ClosedDate(2016,(short)10,(short)3,(short)0,persistedHotel));
		dao.save(new ClosedDate(2016,(short)10,(short)4,(short)0,persistedHotel));
		dao.save(new ClosedDate(2016,(short)10,(short)5,(short)0,persistedHotel));
		
		//saving returned persisted objects in List
		dates = (List) dao.findByParams(persistedHotel, 2016);
		
		//changing details
		dates.get(0).setClosed((short)1);
		dates.get(2).setClosed((short)1);
		dates.get(4).setClosed((short)1);
		
		//updating new details
		service.updateClosedDate(dates, persistedHotel.getHotelId());
		
		//retrieving new list and asserting sucessful update
		dates = (List) dao.findByParams(persistedHotel, 2016);		
		assertEquals((short)1, dates.get(0).getClosed());
		assertEquals((short)0, dates.get(1).getClosed());
		assertEquals((short)1, dates.get(2).getClosed());
		assertEquals((short)0, dates.get(3).getClosed());
		assertEquals((short)1, dates.get(4).getClosed());
		
	}
	
}
