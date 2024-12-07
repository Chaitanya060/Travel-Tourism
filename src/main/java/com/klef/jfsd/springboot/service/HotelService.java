package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Hotels;

public interface HotelService {
	
	public String AddHotel(Hotels hotel);
	   public List<Hotels> ViewAllHotels();
	   public Hotels ViewHotelByID(int hotelid);
	   public void DeleteHotelByID(int hotelid);
	   List<Hotels> viewAllHotelByCategory(String category);
	  

}
