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
import com.jsobral.project.dao.HotelDAO;
import com.jsobral.project.model.Hotel;
import com.jsobral.project.service.HotelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@TransactionConfiguration(defaultRollback=false,transactionManager="transactionManager")
public class HotelTests {
	
	@Autowired
	private HotelDAO dao;
	
	@Autowired
	private Hotel hotel;
	
	@Autowired
	private HotelService service;

	@Test
	@Transactional
	public void testInsertAndUpdate(){
		//creating new hotel to save
		hotel.setHotelName("NEW HOTEL");
		hotel.setHotelAddress("Dublin");
		hotel.setHotelEmail("newhotel@hotels.com");
		hotel.setHotelPhone("963852");
		hotel.setStars((short)5);
		Hotel persistedHotel = (Hotel) dao.save(hotel);
		//Update
		persistedHotel.setHotelPhone("123456789");
		dao.save(persistedHotel);
		//Check update worked
		Hotel resultHotel= dao.findById(Hotel.class, persistedHotel.getHotelId());
		assertEquals("123456789", resultHotel.getHotelPhone());
	}
	
	@Test
	@Transactional
	public void testFilteredGet(){
		//persisting hotel to be returned
		hotel.setHotelName("NEW TEST HOTEL");
		hotel.setHotelAddress("Dublin");
		hotel.setHotelEmail("newhotel@hotels.com");
		//setting 8 stars to get one result back from test
		hotel.setStars((short)8);
		dao.save(hotel);
		
		//preping search  fields object to be sent to find method, only stars is matchable
		Hotel persistedHotel = new Hotel();
		persistedHotel.setHotelName("");
		persistedHotel.setHotelEmail("");
		persistedHotel.setHotelAddress("");		
		persistedHotel.setStars((short)8);
		
		List testList = service.findByParams(persistedHotel);
		Hotel hotel0 = (Hotel)testList.get(0);
		System.out.println(hotel0.getHotelName()+" "+hotel0.getStars()+" stars" );
		assertEquals(testList.size(),1);
	}
}
