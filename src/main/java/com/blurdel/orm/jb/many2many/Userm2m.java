package com.blurdel.orm.jb.many2many;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
@Table(name="USER_M2M")
public class Userm2m {

	@Id
	@GeneratedValue
	private int id;
	
	@NotFound(action=NotFoundAction.IGNORE)
	private String username;
	
	@ManyToMany
	@JoinTable(name="USER_VEHICLE")
	private Collection<Vehiclem2m> vehicle = new ArrayList<>();
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Collection<Vehiclem2m> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehiclem2m> vehicle) {
		this.vehicle = vehicle;
	}
	
	@Override
	public String toString() {
		return "User12many [id=" + id + ", username=" + username + ", vehicle=" + vehicle + "]";
	}
	
}
