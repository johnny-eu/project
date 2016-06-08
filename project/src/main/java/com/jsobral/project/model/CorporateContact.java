package com.jsobral.project.model;

import java.io.Serializable;
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
@Table(name="CORPORATE_CONTACTS")
public class CorporateContact implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CONTACT_ID")
	private int contactId;
	@Column(name="CONTACT_NAME")
	private String contactName;
	@Column(name="CONTACT_SURNAME")
	private String contactSurname;
	@Column(name="CONTACT_PHONE")
	private String contactPhone;
	@Column(name="CONTACT_EMAIL")
	private String contactEmail;
	@ManyToOne
	private Corporate corporate;
	
	
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactSurname() {
		return contactSurname;
	}
	public void setContactSurname(String contactSurname) {
		this.contactSurname = contactSurname;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
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
		result = prime * result + ((contactEmail == null) ? 0 : contactEmail.hashCode());
		result = prime * result + ((contactSurname == null) ? 0 : contactSurname.hashCode());
		result = prime * result + ((corporate == null) ? 0 : corporate.hashCode());
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
		CorporateContact other = (CorporateContact) obj;
		if (contactEmail == null) {
			if (other.contactEmail != null)
				return false;
		} else if (!contactEmail.equals(other.contactEmail))
			return false;
		if (contactSurname == null) {
			if (other.contactSurname != null)
				return false;
		} else if (!contactSurname.equals(other.contactSurname))
			return false;
		if (corporate == null) {
			if (other.corporate != null)
				return false;
		} else if (!corporate.equals(other.corporate))
			return false;
		return true;
	}
		
		
}
