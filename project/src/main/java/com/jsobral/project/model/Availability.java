package com.jsobral.project.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="AVAILABILITY")
public class Availability implements Serializable{


	private static final long serialVersionUID = -343540947418259264L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AVAILABILITY_ID")
	private int rowId;
	@Column(name="YEAR")
	private int year;
	@Column(name="MONTH")
	private short month;
	@Column(name="DAY")
	private short day;
	@Column(name="PRICE")
	private double price;
	@Column(name="AVAIL_ROOMS")
	private short availableRooms;
	@Column(name="RELEASE_DAYS")
	private int releaseDays;
	@Column(name="CLOSED")
	private short closed;
	
	@ManyToOne
	@JoinColumn(name="ROOM_ID")
	private RoomType roomType;
	@ManyToOne
	@JoinColumn(name="HOTEL_ID")
	private Hotel hotel;
	
	
	public int getRowId() {
		return rowId;
	}
	public void setRowId(int rowId) {
		this.rowId = rowId;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public short getMonth() {
		return month;
	}
	public void setMonth(short month) {
		this.month = month;
	}
	public short getDay() {
		return day;
	}
	public void setDay(short day) {
		this.day = day;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public short getAvailableRooms() {
		return availableRooms;
	}
	public void setAvailableRooms(short availableRooms) {
		this.availableRooms = availableRooms;
	}
	public int getReleaseDays() {
		return releaseDays;
	}
	public void setReleaseDays(int releaseDays) {
		this.releaseDays = releaseDays;
	}
	public short getClosed() {
		return closed;
	}
	public void setClosed(short closed) {
		this.closed = closed;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + month;
		result = prime * result + ((roomType == null) ? 0 : roomType.hashCode());
		result = prime * result + rowId;
		result = prime * result + year;
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
		Availability other = (Availability) obj;
		if (day != other.day)
			return false;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (month != other.month)
			return false;
		if (roomType == null) {
			if (other.roomType != null)
				return false;
		} else if (!roomType.equals(other.roomType))
			return false;
		if (rowId != other.rowId)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
		
}
