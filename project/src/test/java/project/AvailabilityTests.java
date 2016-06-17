package project;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jsobral.project.dao.BaseDAO;
import com.jsobral.project.model.Availability;
import com.jsobral.project.model.Hotel;
import com.jsobral.project.model.RoomType;
import com.jsobral.project.service.AvailabilityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@TransactionConfiguration(defaultRollback = false, transactionManager = "transactionManager")
public class AvailabilityTests {

	@Autowired
	private AvailabilityService service;

	@Autowired
	@Qualifier("baseDAO")
	private BaseDAO dao;

	@Test
	@Transactional
	public void testInsertAndFetch() {
		// creating hotel for necessary tests
		Hotel hotel = new Hotel();
		Hotel persistedHotel = (Hotel) dao.save(hotel);

		// creating room for necessary tests
		RoomType room = new RoomType();
		RoomType persistedRoom = (RoomType) dao.save(room);

		// creating availability to insert
		Availability av = new Availability();
		av.setPrice(15.2);
		av.setReleaseDays(3);
		av.setAvailableRooms((short) 3);
		av.setHotel(persistedHotel);
		av.setClosed((short) 0);
		av.setDay((short) 1);
		av.setMonth((short) 1);
		av.setYear((short) 2016);
		av.setRoomType(persistedRoom);

		// saving and retrieving
		Availability persistedAv = (Availability) dao.save(av);
		int avid = persistedAv.getRowId();
		Availability retrievedAv = dao.findById(Availability.class, avid);

		// asserting correct value was set and retrieved for object field
		assertEquals(retrievedAv.getAvailableRooms(), (short) 3);

	}

	@Test
	@Transactional
	public void testUpdate() {
		List<Availability> list = new ArrayList<>();
		
		// creating hotel for necessary tests
		Hotel hotel = new Hotel();
		Hotel persistedHotel = (Hotel) dao.save(hotel);

		// creating room for necessary tests
		RoomType room = new RoomType();
		RoomType persistedRoom = (RoomType) dao.save(room);

		// creating availability to insert
		Availability av = new Availability();
		av.setPrice(15.2);
		av.setReleaseDays(3);
		av.setAvailableRooms((short) 3);
		av.setHotel(persistedHotel);
		av.setClosed((short) 0);
		av.setDay((short) 1);
		av.setMonth((short) 1);
		av.setYear((short) 2016);
		av.setRoomType(persistedRoom);
		
		Availability av2 = new Availability();
		av2.setPrice(15.2);
		av2.setReleaseDays(3);
		av2.setAvailableRooms((short) 3);
		av2.setHotel(persistedHotel);
		av2.setClosed((short) 0);
		av2.setDay((short) 2);
		av2.setMonth((short) 1);
		av2.setYear((short) 2016);
		av2.setRoomType(persistedRoom);
		
		Availability av3 = new Availability();
		av3.setPrice(10.0);
		av3.setReleaseDays(3);
		av3.setAvailableRooms((short) 3);
		av3.setHotel(persistedHotel);
		av3.setClosed((short) 0);
		av3.setDay((short) 3);
		av3.setMonth((short) 1);
		av3.setYear((short) 2016);
		av3.setRoomType(persistedRoom);
		
		list.add((Availability)dao.save(av));
		list.add((Availability)dao.save(av2));
		list.add((Availability)dao.save(av3));
		
		list.get(0).setAvailableRooms((short) 4);
		list.get(1).setAvailableRooms((short) 5);
		list.get(2).setAvailableRooms((short) 6);
		
		service.updateAvailability(list, persistedHotel.getHotelId());
		
		list = null;
		
		list = service.findByParams(2016, (short) 1, persistedRoom.getRoomId());
		
		assertEquals(list.get(0).getAvailableRooms(),(short) 4);
		assertEquals(list.get(1).getAvailableRooms(),(short) 5);
		assertEquals(list.get(2).getAvailableRooms(),(short) 6);
		
	}

}
