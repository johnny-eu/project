package com.jsobral.project.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="AVAILABILITY")
public class Availability implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AVAILABILITY_ID")
	private int rowId;
	@Column(name="DATE")
	private Date date;
	@Column(name="PRICE")
	private double price;
	@Column(name="AVAIL_ROOMS")
	private short availableRooms;
	@Column(name="RELEASE_DAYS")
	private short releaseDays;
	@Column(name="CLOSED")
	private short closed;
	@ManyToOne
	private RoomType roomType;
	@ManyToOne
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public short getReleaseDays() {
		return releaseDays;
	}
	public void setReleaseDays(short releaseDays) {
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
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + ((roomType == null) ? 0 : roomType.hashCode());
		result = prime * result + rowId;
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
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
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
		if (rowId != other.rowId)
			return false;
		return true;
	}
		
}
