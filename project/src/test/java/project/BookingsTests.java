package project;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.jsobral.project.dao.BookingDAO;
import com.jsobral.project.model.Booking;
import com.jsobral.project.model.Customer;
import com.jsobral.project.model.Hotel;
import com.jsobral.project.model.Payment;
import com.jsobral.project.model.RoomType;
import com.jsobral.project.service.BookingService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@TransactionConfiguration(defaultRollback = false, transactionManager = "transactionManager")
public class BookingsTests {

	@Autowired
	private BookingService service;
	
	@Autowired
	private BookingDAO dao;
	
	@Test
	public void testInsertAndFetch(){
		
		Customer customer = new Customer();
		customer.setEmail("john@doe.ie");
		customer.setSurname("Doe2");
		Customer persistedCustomer = (Customer) dao.save(customer);
		
		Payment pay = new Payment();
		pay.setCard(4444555566667777L);
		pay.setCode(555);
		pay.setType(Payment.VISA);
		pay.setTotal(99.00);
		Payment persistedPay = (Payment) dao.save(pay);
		
		RoomType room = new RoomType();
		room.setRoomName("Double");
		room.setRoomDescription("This is a room");
		room.setAdults((short)2);
		room.setChildren((short)0);
		room.setImageIdentifier("x654sdsdf654");
		RoomType persistedRoom = (RoomType) dao.save(room);
		
		Hotel hotel = new Hotel();
		hotel.setHotelAddress("Madrid");
		hotel.setHotelName("Madrid Hotel");
		Hotel persistedHotel = (Hotel) dao.save(hotel);
		
		Booking booking = new Booking();
		booking.setAdults((short)2);
		booking.setArrival(new Date("01/01/2017"));
		booking.setDeparture(new Date("02/01/2017"));
		booking.setChildren((short)0);
		booking.setCreated(new Date());
		booking.setCustomer(persistedCustomer);
		booking.setPayment(persistedPay);
		booking.setRoomType(persistedRoom);
		booking.setHotel(persistedHotel);
		booking.setHotelReference("");
		
		dao.save(booking);
		
		Booking searchObject = new Booking();
		searchObject.setHotel(persistedHotel);
		searchObject.setArrival(new Date());
		searchObject.setCustomer(new Customer());
		searchObject.getCustomer().setSurname("Doe");
		searchObject.getCustomer().setEmail("");
		searchObject.setHotelReference("");
		
		List list = dao.findByParams(searchObject);
		System.out.println(list.size());
		assertEquals(list.size()>0,true);
		
	}
	
	@Test
	public void updateHotelReference(){
		
		Booking booking = new Booking();
		booking.setAdults((short)2);
		booking.setArrival(new Date("01/01/2017"));
		booking.setDeparture(new Date("02/01/2017"));
		booking.setChildren((short)0);
		booking.setCreated(new Date());
		booking.setHotelReference("");
		
		Booking persisted = (Booking) dao.save(booking);
		service.updateHotelReference("NewRef", persisted.getBookingId());
		
		Booking updated = dao.findById(Booking.class, persisted.getBookingId());
		System.out.println(updated.getBookingId() +" " + updated.getHotelReference());
		assertEquals(updated.getHotelReference(),"NewRef");
	}
	

}
