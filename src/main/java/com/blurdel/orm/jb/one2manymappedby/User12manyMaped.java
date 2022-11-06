package com.blurdel.orm.jb.one2manymappedby;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="USER_12M_MAPED")
public class User12manyMaped {

	@Id
	@GeneratedValue
	private int id;
	private String username;
	
	@OneToMany(mappedBy="user12m")
	private Collection<Vehicle12manyMaped> vehicle = new ArrayList<>();
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Collection<Vehicle12manyMaped> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle12manyMaped> vehicle) {
		this.vehicle = vehicle;
	}
	
	@Override
	public String toString() {
		return "User12many [id=" + id + ", username=" + username + ", vehicle=" + vehicle + "]";
	}
	
}
