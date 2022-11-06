package com.blurdel.orm.jb.one2many;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="VEHICLE_12M")
public class Vehicle12many {

	@Id
	@GeneratedValue
	private int vehicleId;
	private String name;
	
//	@ManyToOne
//	private User12many user12m;
	
	
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
//	
//	public User12many getUser12m() {
//		return user12m;
//	}
//	public void setUser12m(User12many user12m) {
//		this.user12m = user12m;
//	}
	
}
