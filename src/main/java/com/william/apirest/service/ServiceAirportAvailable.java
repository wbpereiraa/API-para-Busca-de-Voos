package com.william.apirest.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.william.apirest.dtos.AirportAvailableRecordDto;
import com.william.apirest.entities.AirportAvailable;
import com.william.apirest.repositories.AirportAvailableRepository;

@Service
public class ServiceAirportAvailable {
	
	@Autowired
	private AirportAvailableRepository airportAvailableRepository;

	public AirportAvailable saveAirport(AirportAvailableRecordDto airportAvailableRecordDto) {
		AirportAvailable airportAvailable = new AirportAvailable();
		BeanUtils.copyProperties(airportAvailableRecordDto, airportAvailable);
		return airportAvailableRepository.save(airportAvailable);
	}
	
	public List<AirportAvailable> getAllAirports(){
		return airportAvailableRepository.findAll();
	}
	
	public List<AirportAvailable> findByAirport(String airportName){
		return airportAvailableRepository.findByairportNameContainingIgnoreCase(airportName);
	}
	
	public Object updateAirport(@PathVariable(value="id") UUID id, AirportAvailableRecordDto airportAvailableRecordDto){
		Optional<AirportAvailable> airport = airportAvailableRepository.findById(id);
		if(airport.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Airport not found.");
		}
		var AirportAvailable = airport.get();
		BeanUtils.copyProperties(airportAvailableRecordDto, AirportAvailable);
		return airportAvailableRepository.save(AirportAvailable);
		
	}
	
	public Object deleteAirport(@PathVariable(value="id") UUID id){
		Optional<AirportAvailable> airport = airportAvailableRepository.findById(id);
		if(airport.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Airport not found.");
		}
		airportAvailableRepository.delete(airport.get());
		return ResponseEntity.status(HttpStatus.OK).body("Airport deleted sucessfuly.");
	}
}
