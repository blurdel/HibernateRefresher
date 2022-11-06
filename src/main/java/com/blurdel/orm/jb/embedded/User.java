package com.blurdel.orm.jb.embedded;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int id;
	
	@Column(name="USER_NAME")
	private String username;
	
	@Column(name="AGE")
	private int age;
	
	//@Transient
	//@Basic(fetch=FetchType.LAZY)
	@Column(name="BREED")
	private String breed;
	
	@Embedded
	private Address address;
	
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="street", column=@Column(name="VACA_STREET")),
	@AttributeOverride(name="city", column=@Column(name="VACA_CITY")),
	@AttributeOverride(name="state", column=@Column(name="VACA_STATE")),
	@AttributeOverride(name="zip", column=@Column(name="VACA_ZIP"))
	})
	private Address vacaAddress;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", age=" + age + ", breed=" + breed + "]";
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Address getVacaAddress() {
		return vacaAddress;
	}
	public void setVacaAddress(Address vacaAddress) {
		this.vacaAddress = vacaAddress;
	}
}
