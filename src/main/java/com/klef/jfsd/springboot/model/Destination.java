package com.klef.jfsd.springboot.model;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Destination {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,length = 100)
	private String place; 
	@Column(nullable = false,length = 100)
    private String description;
    @Column(nullable = false,length = 100)
    private String rating;
    private Blob placeimage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Blob getPlaceimage() {
		return placeimage;
	}
	public void setPlaceimage(Blob placeimage) {
		this.placeimage = placeimage;
	}
	@Override
	public String toString() {
		return "Destination [id=" + id + ", place=" + place + ", description=" + description + ", rating=" + rating
				+ ", placeimage=" + placeimage + "]";
	}

}
