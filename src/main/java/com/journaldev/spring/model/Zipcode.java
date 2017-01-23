package com.journaldev.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zipcode")
public class Zipcode {

	@Id
	@Column(name="zipid")
	private String zipid;
	
	@Column(name="lat")
	private double lat;
	
	@Column(name="lng")
	private double lng;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	public Zipcode() {
		
	}
	
	public Zipcode(String zip, double lat, double lng) {
		this.zipid = zip;
		this.lat = lat;
		this.lng = lng;
	}

	public String getZipid() {
		return zipid;
	}

	public void setZipid(String zipid) {
		this.zipid = zipid;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}