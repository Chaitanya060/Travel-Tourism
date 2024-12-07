package com.klef.jfsd.springboot.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Hotels;
@Repository
public interface HotelRepository extends CrudRepository<Hotels, Integer>{
	
	@Query("from Hotels h where h.category=?1")
	public List<Hotels> viewAllHotelByCategory(String category);
	

}
