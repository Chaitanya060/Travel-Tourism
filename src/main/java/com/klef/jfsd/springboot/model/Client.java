package com.klef.jfsd.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name",length = 20,nullable = false)
	private String fname;
	
	@Column(name = "last_name",length = 20,nullable = false)
	private String lname;
	
	@Column(name = "location",length = 20,nullable = false)
	private String location;
	
	@Column(nullable = false,unique = true)
	private String email;
	
	@Column(length=20,nullable = false)
	private String password;
	
	@Column(length = 10,name = "mobile_number",unique = true,nullable = false)
	private String mobile;
	
	@Column(nullable = false)
	private String gender;
	
	@Column(nullable = false)
	private  String dob;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", fname=" + fname + ", lname=" + lname + ", location=" + location + ", email="
				+ email + ", password=" + password + ", mobile=" + mobile + ", gender=" + gender + ", dob=" + dob + "]";
	}

}
