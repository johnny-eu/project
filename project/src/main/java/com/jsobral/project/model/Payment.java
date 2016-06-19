package com.jsobral.project.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 * Class used as a DTO to send data from view to the DB and back. Used to carry data about
 * payments such as card information and amount to pay.
 * Hibernate uses this entity as a map to a DB table and is anotated accordingly including relations 
 * to other tables.
 * @author joao
 * Copyright 2016, Joao Sobral, All rights reserved.
 */
@Entity
@Component
@Table(name="PAYMENTS")
public class Payment implements Serializable{
	

	private static final long serialVersionUID = -3718766294958689283L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PAY_ID")
	private int payId;
	@Column(name="CARD_TYPE")
	private String type;
	@Column(name="CARD_NUM")
	private long card;
	@Column(name="CARD_EXP")
	private int expiry;
	@Column(name="CVV")
	private int code;
	@Column(name="BOOKING_TOTAL")
	private double total;
	@Column(name="BOOKING_COMMISSION")
	private double commission;
	
	/**
	 * a payment is associated with one booking
	 */
	@OneToOne
	private Booking booking;
	
	//GETTERS AND SETTERS
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getCard() {
		return card;
	}
	public void setCard(long card) {
		this.card = card;
	}
	public int getExpiry() {
		return expiry;
	}
	public void setExpiry(int expiry) {
		this.expiry = expiry;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (card ^ (card >>> 32));
		result = prime * result + expiry;
		result = prime * result + payId;
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Payment other = (Payment) obj;
		if (card != other.card)
			return false;
		if (expiry != other.expiry)
			return false;
		if (payId != other.payId)
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}
	
}
