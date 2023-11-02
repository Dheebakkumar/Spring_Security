package com.SpringSecurity.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "SECURITY")
public class Security {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private long id;
	
	@Column(name = "USER_NAME")
	private String name;
	
	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	

	public Security() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Security [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", gender=" + gender
				+ ", dob=" + dob + "]";
	}
	
	
}
