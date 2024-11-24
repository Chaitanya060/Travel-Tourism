package com.klef.jfsd.springboot.model;


import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hotels {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,length = 100)
	private String hotelname; 
	@Column(nullable = false,length = 100)
    private String location;
    @Column(nullable = false,length = 100)
    private String price;
    @Column(nullable = false,length = 100)
    private double rating;
    private Blob hotelimage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public Blob getHotelimage() {
		return hotelimage;
	}
	public void setHotelimage(Blob hotelimage) {
		this.hotelimage = hotelimage;
	}
	@Override
	public String toString() {
		return "Hotels [id=" + id + ", hotelname=" + hotelname + ", location=" + location + ", price=" + price
				+ ", rating=" + rating + ", hotelimage=" + hotelimage + "]";
	}

}
