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

@Entity
@Component
@Table(name="CLOSED_DATES")
public class ClosedDate implements Serializable{
	

	private static final long serialVersionUID = -4246293318478118037L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CLOSED_DATE_ID")
	private int closedDateId;
	@Column(name="DATE")
	private Date date;
	@Column(name="CLOSED")
	private short closed;
	
	@ManyToOne
	@JoinColumn(name="HOTEL_ID")
	private Hotel hotel;
	
	
	public int getClosedDateId() {
		return closedDateId;
	}
	public void setClosedDateId(int closedDateId) {
		this.closedDateId = closedDateId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
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
		return true;
	}
	
}
