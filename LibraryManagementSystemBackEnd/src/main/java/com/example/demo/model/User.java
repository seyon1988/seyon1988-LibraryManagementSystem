package com.example.demo.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table( name = "users" )
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;
	
	@Column(name = "first_Name")
	private String firstName;
	
	@Column(name = "last_Name")
	private String lastName;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "email_id")
	private String emailID;
	
	
	@Column(name = "password")
	private String password;
	

	@Column(name = "book_quota")
	private int bookQuota;
	
	


	@Column(name = "utilized_quota")
	private int utilizedQuota;
	



	public User() {

	}



	public User(String firstName, String lastName, String role, String emailID, String password, int bookQuota,
			int utilizedQuota) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.emailID = emailID;
		this.password = password;
		this.bookQuota = bookQuota;
		this.utilizedQuota = utilizedQuota;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	
	public int getBookQuota() {
		return bookQuota;
	}



	public void setBookQuota(int bookQuota) {
		this.bookQuota = bookQuota;
	}



	public int getUtilizedQuota() {
		return utilizedQuota;
	}



	public void setUtilizedQuota(int utilizedQuota) {
		this.utilizedQuota = utilizedQuota;
	}


	
}
