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
@Table(name="CLOSED_DATES")
public class ClosedDate implements Serializable{
	

	private static final long serialVersionUID = 5373683123856215630L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CLOSED_DATE_ID")
	private int closedDateId;
	@Column(name="YEAR")
	private int year;
	@Column(name="MONTH")
	private short month;
	@Column(name="DAY")
	private short day;
	@Column(name="CLOSED")
	private short closed;
	
	@ManyToOne
	@JoinColumn(name="HOTEL_ID")
	private Hotel hotel;
	
	
	public ClosedDate() {	}
	
	public ClosedDate(int year, short month, short day, short closed, Hotel hotel) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.closed = closed;
		this.hotel = hotel;
	}

	public int getClosedDateId() {
		return closedDateId;
	}
	public void setClosedDateId(int closedDateId) {
		this.closedDateId = closedDateId;
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
	public short getClosed() {
		return closed;
	}
	public void setClosed(short closed) {
		this.closed = closed;
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
		result = prime * result + closedDateId;
		result = prime * result + day;
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + month;
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
		ClosedDate other = (ClosedDate) obj;
		if (closedDateId != other.closedDateId)
			return false;
		if (day != other.day)
			return false;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	
}
