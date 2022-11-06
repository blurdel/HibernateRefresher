package com.blurdel.orm.jb.embedded;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Address implements Serializable {

	private static final long serialVersionUID = -6847843121857391672L;

	@Column(name="STREET_NAME")
	private String street;
	
	@Column(name="CITY_NAME")
	private String city;
	
	@Column(name="STATE_NAME")
	private String state;
	
	@Column(name="ZIP_CODE")
	private String zip;
	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}
	
}
