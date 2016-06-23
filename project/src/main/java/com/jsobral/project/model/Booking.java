package com.jsobral.project.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * Class used as a DTO to send data from view to the DB and back. Used to carry data about
 * Bookings with their dates and customer/payment information for hotels to access on the browser.
 * Hibernate uses this entity as a map to a DB table and is anotated accordingly including relations 
 * to other tables.
 * @author joao
 * Copyright 2016, Joao Sobral, All rights reserved.
 */
@Entity
@Component
@Table(name="BOOKINGS")
public class Booking implements Serializable{

	public static final short PENDING = 1;
	public static final short CONFIRMED = 2;
	public static final short CANCELLED = 3;
	
	private static final long serialVersionUID = 378711901115296383L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BOOKING_ID")
	private int bookingId;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="ARRIVAL")
	@Temporal(TemporalType.DATE)
	private Date arrival;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="DEPARTURE")
	private Date departure;
	
	@Column(name="ADUTS")
	private short adults;
	@Column(name="CHILDREN")
	private short children;
	@Column(name="STATUS")
	private short status;
	@Column(name="HOTEL_REF")
	private String hotelReference;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="DATE_CREATED")
	@Temporal(TemporalType.DATE)
	private Date created;
	
	/**
	 * The customer the booking belongs to
	 */
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;
	
	/**
	 * The hotel booked
	 */
	@ManyToOne
	@JoinColumn(name="HOTEL_ID")
	private Hotel hotel;
	
	/**
	 * the room type booked
	 */
	@ManyToOne
	@JoinColumn(name="ROOM_ID")
	private RoomType roomType;	
	
	/**
	 * the payment associated with this booking
	 */
	@OneToOne
	@JoinColumn(name="PAY_ID")
	private Payment payment;
	
	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public Date getArrival() {
		return arrival;
	}
	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}
	public Date getDeparture() {
		return departure;
	}
	public void setDeparture(Date departure) {
		this.departure = departure;
	}
	public short getAdults() {
		return adults;
	}
	public void setAdults(short adults) {
		this.adults = adults;
	}
	public short getChildren() {
		return children;
	}
	public void setChildren(short children) {
		this.children = children;
	}
	public short getStatus() {
		return status;
	}
	public void setStatus(short status) {
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public String getHotelReference() {
		return hotelReference;
	}
	public void setHotelReference(String hotelReference) {
		this.hotelReference = hotelReference;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookingId;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + ((roomType == null) ? 0 : roomType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		if (bookingId != other.bookingId)
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (roomType == null) {
			if (other.roomType != null)
				return false;
		} else if (!roomType.equals(other.roomType))
			return false;
		return true;
	}
	
		
}
