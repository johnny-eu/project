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
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 * Class used as a DTO to send data from view to the DB and back. Used to carry data about
 * promotions like the start date, end date, name and description, image and price.
 * Hibernate uses this entity as a map to a DB table and is anotated accordingly including relations 
 * to other tables.
 * @author joao
 * Copyright 2016, Joao Sobral, All rights reserved.
 */
@Entity
@Component
@Table(name="PROMOTIONS")
public class Promotion implements Serializable{
	

	private static final long serialVersionUID = 771839612881761458L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PROMOTION_ID")
	private int promotionId;
	@Column(name="PROMOTION_NAME")
	private String promotionName;
	@Column(name="PROMOTION_DESC")
	private String promotionDescription;
	@Column(name="PROMOTION_IMG")
	private String imageId;
	@Column(name="PROMOTION_START")
	private Date startDate;
	@Column(name="PROMOTION_END")
	private Date endDate;
	@Column(name="PROMOTION_PRICE")
	private double price;
	
	/**
	 * A promotion belongs to one hotel
	 */
	@ManyToOne
	@JoinColumn(name="HOTEL_ID")
	private Hotel hotel;
	
	/**
	 * a promotion is linked to one room type
	 */
	@ManyToOne
	@JoinColumn(name="ROOM_ID")
	private RoomType roomType;
	
	//GETTERS AND SETTERS
	public int getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}
	public String getPromotionName() {
		return promotionName;
	}
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	public String getPromotionDescription() {
		return promotionDescription;
	}
	public void setPromotionDescription(String promotionDescription) {
		this.promotionDescription = promotionDescription;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + promotionId;
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
		Promotion other = (Promotion) obj;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (promotionId != other.promotionId)
			return false;
		if (roomType == null) {
			if (other.roomType != null)
				return false;
		} else if (!roomType.equals(other.roomType))
			return false;
		return true;
	}
	

}
