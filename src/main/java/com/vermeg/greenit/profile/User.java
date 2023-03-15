package com.vermeg.greenit.profile;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	
	@Id
	@Column(name = "mail", nullable = false)
	private String mail;
	private String password;
	
	@OneToOne
	private Profile profile;

	public User() {
	}

	public User(String mail, String password) {
		this.setMail(mail);
		this.setPassword(password);

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "user{" + "mail=" + mail + ", password='" + password + " " + '}';
	}

	

	
}