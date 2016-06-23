package com.jsobral.project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jsobral.project.model.Booking;
import com.jsobral.project.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingsController {

	@Autowired
	private BookingService service;
	
	@RequestMapping(
			method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List> getBookings(@RequestParam Map<String,String> params){
		List bookings= service.findByParams(
				Integer.parseInt(params.get("hotelId")),
				params.get("arrival"),
				params.get("custEmail"),
				params.get("custSurname"),
				params.get("hotelRef")
				);
		return new ResponseEntity<>(bookings,HttpStatus.OK);
	}
	
}
