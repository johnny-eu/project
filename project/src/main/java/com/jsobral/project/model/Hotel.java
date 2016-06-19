package com.jsobral.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 * Class used as a DTO to send data from view to the DB and back. Used to carry data about
 * a hotel, its address, name, classification and contacts.
 * Hibernate uses this entity as a map to a DB table and is anotated accordingly including relations 
 * to other tables.
 * @author joao
 * Copyright 2016, Joao Sobral, All rights reserved.
 */
@Entity
@Component
@Table(name="HOTELS")
public class Hotel implements Serializable{
	

	private static final long serialVersionUID = 5395904930062419286L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="HOTEL_ID")
	private int hotelId;
	@Column(name="HOTEL_NAME")
	private String hotelName;
	@Column(name="HOTEL_ADDR")
	private String hotelAddress;
	@Column(name="HOTEL_PHONE")
	private String hotelPhone;
	@Column(name="HOTEL_EMAIL")
	private String hotelEmail;
	@Column(name="HOTEL_STARS")
	private short stars;
	@Column(name="HOTEL_STATUS")
	private short disabled;
	
	/**
	 * a hotel may have several corporate contracts
	 */
	@OneToMany(mappedBy="hotel",cascade=CascadeType.ALL)
	private Collection<Corporate> corporate = new ArrayList<Corporate>();
	
	/**
	 * a hotel may have several bookings
	 */
	@OneToMany(mappedBy="hotel",cascade=CascadeType.ALL)
	private Collection<Booking> bookings = new ArrayList<Booking>();
	
	/**
	 * a hotel may have several room types
	 */
	@OneToMany(mappedBy="hotel",cascade=CascadeType.ALL)
	private Collection<RoomType> roomTypes = new ArrayList<RoomType>();	
	
	/**
	 * a hotel has several close out dates entries
	 */
	@OneToMany(mappedBy="hotel",cascade=CascadeType.ALL)
	private Collection<ClosedDate> closedDates = new ArrayList<ClosedDate>();
	
	/**
	 * a hotel may have several promotions
	 */
	@OneToMany(mappedBy="hotel",cascade=CascadeType.ALL)
	private Collection<Promotion> promotions = new ArrayList<Promotion>();
	
	/**
	 * a hotel has several availability entries per room type
	 */
	@OneToMany(mappedBy="hotel",cascade=CascadeType.ALL)
	private Collection<Availability> availability = new ArrayList<Availability>();
	
	/**
	 * a hotel has several facilities entries
	 */
	@OneToMany(mappedBy="hotel",cascade=CascadeType.ALL)
	private Collection<Facility> facilities = new ArrayList<Facility>();
	
	/**
	 * a hotel has one login associated
	 */
	@OneToOne
	@JoinColumn(name="LOGIN_ID")
	private Login login;
	
	//GETTERS AND SETTERS
	public void addCorporate(Corporate company){
		company.setHotel(this);
		corporate.add(company);		
	}
	public Collection<Facility> getFacilities() {
		return facilities;
	}
	public void setFacilities(Collection<Facility> facilities) {
		this.facilities = facilities;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public Collection<Corporate> getCorporate() {
		return corporate;
	}
	public void setCorporate(Collection<Corporate> corporate) {
		this.corporate = corporate;
	}
	public Collection<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(Collection<Booking> bookings) {
		this.bookings = bookings;
	}
	public Collection<RoomType> getRoomTypes() {
		return roomTypes;
	}
	public void setRoomTypes(Collection<RoomType> roomTypes) {
		this.roomTypes = roomTypes;
	}
	public Collection<ClosedDate> getClosedDates() {
		return closedDates;
	}
	public void setClosedDates(Collection<ClosedDate> closedDates) {
		this.closedDates = closedDates;
	}
	public Collection<Promotion> getPromotions() {
		return promotions;
	}
	public void setPromotions(Collection<Promotion> promotions) {
		this.promotions = promotions;
	}
	public Collection<Availability> getAvailability() {
		return availability;
	}
	public void setAvailability(Collection<Availability> availability) {
		this.availability = availability;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelAddress() {
		return hotelAddress;
	}
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	public String getHotelPhone() {
		return hotelPhone;
	}
	public void setHotelPhone(String hotelPhone) {
		this.hotelPhone = hotelPhone;
	}
	public String getHotelEmail() {
		return hotelEmail;
	}
	public void setHotelEmail(String hotelEmail) {
		this.hotelEmail = hotelEmail;
	}
	public short getStars() {
		return stars;
	}
	public void setStars(short stars) {
		this.stars = stars;
	}
	public short getDisabled() {
		return disabled;
	}
	public void setDisabled(short disabled) {
		this.disabled = disabled;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + disabled;
		result = prime * result + ((hotelAddress == null) ? 0 : hotelAddress.hashCode());
		result = prime * result + ((hotelEmail == null) ? 0 : hotelEmail.hashCode());
		result = prime * result + hotelId;
		result = prime * result + ((hotelName == null) ? 0 : hotelName.hashCode());
		result = prime * result + ((hotelPhone == null) ? 0 : hotelPhone.hashCode());
		result = prime * result + stars;
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
		Hotel other = (Hotel) obj;
		if (disabled != other.disabled)
			return false;
		if (hotelAddress == null) {
			if (other.hotelAddress != null)
				return false;
		} else if (!hotelAddress.equals(other.hotelAddress))
			return false;
		if (hotelEmail == null) {
			if (other.hotelEmail != null)
				return false;
		} else if (!hotelEmail.equals(other.hotelEmail))
			return false;
		if (hotelId != other.hotelId)
			return false;
		if (hotelName == null) {
			if (other.hotelName != null)
				return false;
		} else if (!hotelName.equals(other.hotelName))
			return false;
		if (hotelPhone == null) {
			if (other.hotelPhone != null)
				return false;
		} else if (!hotelPhone.equals(other.hotelPhone))
			return false;
		if (stars != other.stars)
			return false;
		return true;
	}
	
	
	
}
