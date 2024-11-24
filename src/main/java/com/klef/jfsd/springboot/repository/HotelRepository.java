package com.klef.jfsd.springboot.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Hotels;
@Repository
public interface HotelRepository extends CrudRepository<Hotels, Integer>{
	
	

}
