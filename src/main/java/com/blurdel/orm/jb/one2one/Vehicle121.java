package com.blurdel.orm.jb.one2one;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="VEHICLE_121")
public class Vehicle121 {

	@Id
	@GeneratedValue
	private int vehicleId;
	
	private String name;
	
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
		return "Vehicle121 [vehicleId=" + vehicleId + ", name=" + name + "]";
	}
	
}
