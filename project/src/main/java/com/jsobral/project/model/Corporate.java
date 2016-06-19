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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 * Class used as a DTO to send data from view to the DB and back. Used to carry data about
 * Corporate, the company name,address, vat number and hotel it belongs to.
 * Hibernate uses this entity as a map to a DB table and is anotated accordingly including relations 
 * to other tables.
 * @author joao
 * Copyright 2016, Joao Sobral, All rights reserved.
 */
@Entity
@Component
@Table(name="CORPORATE")
public class Corporate implements Serializable{
	
	private static final long serialVersionUID = 3256810273915894350L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CORPORATE_ID")
	private int corporateId;
	@Column(name="COMPANY_NAME")
	private String corporateName;
	@Column(name="COMPANY_ADDRESS")
	private String corporateAddress;
	@Column(name="VAT")
	private String vatNumber;
	
	/**
	 * The company belongs to one hotel
	 */
	@ManyToOne
	@JoinColumn(name="HOTEL_ID")
	private Hotel hotel;
	
	/**
	 * A compay has one contact associated with it
	 */
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="CONTACT_ID")
	private CorporateContact contact;
	
	/**
	 * One corporate can create several promotional prices like per room type/season
	 */
	@OneToMany(mappedBy="corporate",cascade=CascadeType.ALL)
	private Collection<PromoPrice> promoPrices = new ArrayList<PromoPrice>();
	
	
	//GETTERS AND SETTERS
	public Collection<PromoPrice> getPromoPrices() {
		return promoPrices;
	}
	public CorporateContact getContact() {
		return contact;
	}
	public void setContact(CorporateContact contact) {
		this.contact = contact;
	}
	public void setPromoPrices(Collection<PromoPrice> promoPrices) {
		this.promoPrices = promoPrices;
	}
	public int getCorporateId() {
		return corporateId;
	}
	public void setCorporateId(int corporateId) {
		this.corporateId = corporateId;
	}
	public String getCorporateName() {
		return corporateName;
	}
	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}
	public String getCorporateAddress() {
		return corporateAddress;
	}
	public void setCorporateAddress(String corporateAddress) {
		this.corporateAddress = corporateAddress;
	}
	public String getVatNumber() {
		return vatNumber;
	}
	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
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
		result = prime * result + corporateId;
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + ((vatNumber == null) ? 0 : vatNumber.hashCode());
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
		Corporate other = (Corporate) obj;
		if (corporateId != other.corporateId)
			return false;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (vatNumber == null) {
			if (other.vatNumber != null)
				return false;
		} else if (!vatNumber.equals(other.vatNumber))
			return false;
		return true;
	}
		
}
