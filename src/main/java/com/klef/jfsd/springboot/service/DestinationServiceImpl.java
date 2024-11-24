package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Destination;
import com.klef.jfsd.springboot.repository.DestinationRepository;

@Service
public class DestinationServiceImpl implements DestinationService{
	
	@Autowired
	private DestinationRepository destinationRepository;

	@Override
	public String AddDestination(Destination destination) {
		destinationRepository.save(destination);
		return "Destination Added Successfully";
		
		
	}

	@Override
	public List<Destination> ViewAllDestination() {
		return (List<Destination>) destinationRepository.findAll();
	}

	@Override
	public Destination ViewDestinationByID(int destinationid) {
		return destinationRepository.findById(destinationid).get();
		
	}

	@Override
	public void DeleteDestinationByID(int destinationid) {
		destinationRepository.deleteById(destinationid);
		
	}

}
