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
@Table(name="PROMO_PRICES")
public class PromoPrice implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PROMO_PRICE_ID")
	private int priceId;
	@Column(name="PRICE_CODE")
	private String promoPriceCode;
	@Column(name="START")
	private Date startDate;
	@Column(name="PRICE_END")
	private Date endDate;
	@Column(name="PRICE")
	private double price;
	@ManyToOne
	private RoomType roomType;
	@ManyToOne
	private Corporate corporate;
	
	
	public int getPriceId() {
		return priceId;
	}
	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}
	public String getPromoPriceCode() {
		return promoPriceCode;
	}
	public void setPromoPriceCode(String promoPriceCode) {
		this.promoPriceCode = promoPriceCode;
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
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public Corporate getCorporate() {
		return corporate;
	}
	public void setCorporate(Corporate corporate) {
		this.corporate = corporate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corporate == null) ? 0 : corporate.hashCode());
		result = prime * result + priceId;
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
		PromoPrice other = (PromoPrice) obj;
		if (corporate == null) {
			if (other.corporate != null)
				return false;
		} else if (!corporate.equals(other.corporate))
			return false;
		if (priceId != other.priceId)
			return false;
		if (roomType == null) {
			if (other.roomType != null)
				return false;
		} else if (!roomType.equals(other.roomType))
			return false;
		return true;
	}
	
	
}
