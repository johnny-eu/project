package com.jsobral.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="CORPORATE")
public class Corporate implements Serializable{
	
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
	@ManyToOne
	private Hotel hotel;
	@OneToMany
	@JoinColumn(name="CONTACT_ID")
	private Collection<CorporateContact> contacts = new ArrayList<CorporateContact>();
	@OneToMany
	@JoinColumn(name="PROMO_PRICE_ID")
	private Collection<PromoPrice> promoPrices = new ArrayList<PromoPrice>();
	
	
	//GETTERS AND SETTERS
	public Collection<CorporateContact> getContacts() {
		return contacts;
	}
	public void setContacts(Collection<CorporateContact> contacts) {
		this.contacts = contacts;
	}
	public Collection<PromoPrice> getPromoPrices() {
		return promoPrices;
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
