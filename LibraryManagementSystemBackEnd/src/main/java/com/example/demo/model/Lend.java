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
@Table( name = "lend_register" )
public class Lend {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;
	
	@Column(name = "user_id")
	private int userID;
	
	
	@Column(name = "material_id")
	private int materialID;
	
	
	public Lend() {
		// TODO Auto-generated constructor stub
	}

	
	

	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public int getMaterialID() {
		return materialID;
	}


	public void setMaterialID(int materialID) {
		this.materialID = materialID;
	}
	
	
	
	
}
