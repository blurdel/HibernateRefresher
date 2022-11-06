package com.blurdel.orm.jb.embedded;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;


@Entity
@Table(name="USER_COLL")
public class UserColl {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String username;

	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS",
			joinColumns=@JoinColumn(name="USER_ID")
	)
	Set<Address> addrList = new HashSet<>();

	
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

	public Set<Address> getAddrList() {
		return addrList;
	}

	public void setAddrList(Set<Address> addrList) {
		this.addrList = addrList;
	}

	@Override
	public String toString() {
		return "UserColl [id=" + id + ", username=" + username + ", addrList=" + addrList + "]";
	}
	
}
