package com.blurdel.orm.jb.many2many;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="VEHICLE_M2M")
public class Vehiclem2m {

	@Id
	@GeneratedValue
	private int vehicleId;
	private String name;
	
	@ManyToMany(mappedBy="vehicle")
	Collection<Userm2m> users = new ArrayList<>();
	
	
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
	public Collection<Userm2m> getUsers() {
		return users;
	}
	public void setUsers(Collection<Userm2m> users) {
		this.users = users;
	}
	
	
}
