package com.blurdel.orm.jb.one2one;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="USER_121")
public class User121 {

	@Id
	@GeneratedValue
	private int id;
	private String username;
	
	@OneToOne
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle121 vehicle;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Vehicle121 getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle121 vehicle) {
		this.vehicle = vehicle;
	}
	@Override
	public String toString() {
		return "User121 [id=" + id + ", username=" + username + ", vehicle=" + vehicle + "]";
	}
	
}
