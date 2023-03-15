package com.vermeg.greenit.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Profile")
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "email")
	private String email;
	private int number;
	private String username;
	private String itinerary;
	private String address;
	private String addressJob;
	private String calendar;
	@OneToOne
	private User user;

	public Profile() {
	}

	public Profile(String username) {
		this.setUsername(username);

	}

	public Profile(String username, String itinerary, String address, String addressJob, String calendar, int number) {
		this.setUsername(username);
		this.setItinerary(itinerary);
		this.setAddress(address);
		this.setNumber(number);
		this.setAddressJob(addressJob);
		this.setCalendar(calendar);

	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	

	public String getAddressJob() {
		return addressJob;
	}

	public void setAddressJob(String job) {
		this.addressJob = job;
	}

	public String getItinerary() {
		return itinerary;
	}

	public void setItinerary(String itinerary) {
		this.itinerary = itinerary;
	}

	public String getCalendar() {
		return calendar;
	}

	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Profile(int id, String username, String itinerary) {
		this.setId(id);
		this.setUsername(username);
		this.setItinerary(itinerary);
	}

	public Long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = Long.valueOf(id);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
	    return "Profile[id=" + id + ", username=" + username + ", email=" + email + "]";
	}
	
}