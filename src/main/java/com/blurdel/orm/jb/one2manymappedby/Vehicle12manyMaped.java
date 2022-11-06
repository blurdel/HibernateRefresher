package com.blurdel.orm.jb.one2manymappedby;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="VEHICLE_12M_MAPED")
public class Vehicle12manyMaped {

	@Id
	@GeneratedValue
	private int vehicleId;
	private String name;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User12manyMaped user12m;
	
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Vehicle12many [vehicleId=" + vehicleId + ", name=" + name + "]";
	}
	public User12manyMaped getUser12m() {
		return user12m;
	}
	public void setUser12m(User12manyMaped user12m) {
		this.user12m = user12m;
	}
	
}
