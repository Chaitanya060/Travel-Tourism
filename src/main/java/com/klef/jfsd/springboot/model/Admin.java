package com.klef.jfsd.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Admin {
	
	@Id
	private int id;
	
	@Column(name = "adminname",length = 40,nullable = false)
	private String adminname;
	
	@Column(name="adminpassword",nullable = false,length = 40)
	private String adminpassword;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminname=" + adminname + ", adminpassword=" + adminpassword + "]";
	}
	
	
	
	

}
