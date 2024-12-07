package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Destination;

public interface DestinationService {
	
	   public String AddDestination(Destination destination);
	   public List<Destination> ViewAllDestination();
	   public Destination ViewDestinationByID(int destinationid);
	   public void DeleteDestinationByID(int destinationid);

}
