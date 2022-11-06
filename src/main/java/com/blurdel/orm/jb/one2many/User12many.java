package com.blurdel.orm.jb.one2many;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="USER_12M")
public class User12many {

	@Id
	@GeneratedValue
	private int id;
	private String username;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="USER_VEHICLE",
		joinColumns=@JoinColumn(name="USER_ID"),
		inverseJoinColumns=@JoinColumn(name="VEHICLE_ID")
	)
	private Collection<Vehicle12many> vehicle = new ArrayList<>();
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Collection<Vehicle12many> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle12many> vehicle) {
		this.vehicle = vehicle;
	}
	
	@Override
	public String toString() {
		return "User12many [id=" + id + ", username=" + username + ", vehicle=" + vehicle + "]";
	}
	
}
