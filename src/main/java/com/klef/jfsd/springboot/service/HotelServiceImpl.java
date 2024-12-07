package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Hotels;
import com.klef.jfsd.springboot.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public String AddHotel(Hotels hotel) {
		hotelRepository.save(hotel);
		return "Hotel Added Successfully";
		
	}

	

	@Override
	public Hotels ViewHotelByID(int hotelid) {
		return hotelRepository.findById(hotelid).get();
		
		
	}

	@Override
	public void DeleteHotelByID(int hotelid) {
		
		hotelRepository.deleteById(hotelid);
			
	}



	@Override
	public List<Hotels> ViewAllHotels() {
		return (List<Hotels>) hotelRepository.findAll();
	}



	@Override
	public List<Hotels> viewAllHotelByCategory(String category) {
		
		return hotelRepository.viewAllHotelByCategory(category);
		
		
	}



	
	

}
