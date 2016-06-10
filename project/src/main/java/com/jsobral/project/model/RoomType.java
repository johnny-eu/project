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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="ROOM_TYPES")
public class RoomType implements Serializable{


	private static final long serialVersionUID = -3109857026185144630L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ROOM_ID")
	private int roomId;
	@Column(name="ROOM_NAME")
	private String roomName;
	@Column(name="ROOM_DESC")
	private String roomDescription;
	@Column(name="ROOM_IMG")
	private String imageIdentifier;
	@Column(name="ROOM_MAX_ADUL")
	private short adults;
	@Column(name="ROOM_MAX_CHIL")
	private short children;
	@ManyToOne
	private Hotel hotel;
	
	@OneToMany(mappedBy="roomType",cascade=CascadeType.ALL)
	private Collection<Booking> bookings = new ArrayList<Booking>();
	@OneToMany(mappedBy="roomType",cascade=CascadeType.ALL)
	private Collection<PromoPrice> promoPrices = new ArrayList<PromoPrice>();
	@OneToMany(mappedBy="roomType",cascade=CascadeType.ALL)
	private Collection<Promotion> promotions = new ArrayList<Promotion>();
	@OneToMany(mappedBy="roomType",cascade=CascadeType.ALL)
	private Collection<Availability> availability = new ArrayList<Availability>();
	
	
	public Collection<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(Collection<Booking> bookings) {
		this.bookings = bookings;
	}
	public Collection<PromoPrice> getPromoPrices() {
		return promoPrices;
	}
	public void setPromoPrices(Collection<PromoPrice> promoPrices) {
		this.promoPrices = promoPrices;
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
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomDescription() {
		return roomDescription;
	}
	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}
	public String getImageIdentifier() {
		return imageIdentifier;
	}
	public void setImageIdentifier(String imageIdentifier) {
		this.imageIdentifier = imageIdentifier;
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
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + roomId;
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
		RoomType other = (RoomType) obj;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (roomId != other.roomId)
			return false;
		return true;
	}
	
	
}
