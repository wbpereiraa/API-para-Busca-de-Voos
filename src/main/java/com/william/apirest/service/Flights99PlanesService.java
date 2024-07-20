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

import com.william.apirest.dtos.Flights99PlanesPatchRecordDto;
import com.william.apirest.dtos.Flights99PlanesRecordDto;
import com.william.apirest.entities.Flights99Planes;
import com.william.apirest.repositories.Flights99PlanesRepository;

@Service
public class Flights99PlanesService {
	
	@Autowired
	private Flights99PlanesRepository flights99PlanesRepository;

	public Flights99Planes saveFlights(Flights99PlanesRecordDto flights99PlanesRecordDto) {
		Flights99Planes flights99Planes = new Flights99Planes();
		BeanUtils.copyProperties(flights99PlanesRecordDto, flights99Planes);
		return flights99PlanesRepository.save(flights99Planes);
	}
	
	public List<Flights99Planes> getAllFlights(){
		return flights99PlanesRepository.findAll();
	}
	
	public Object getOneFlight(@PathVariable(value="id") UUID id){
		Optional<Flights99Planes> flight = flights99PlanesRepository.findById(id);
		if(flight.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found.");
		}
		return flights99PlanesRepository.findById(id);
	}
	
	public Object updateFlight(@PathVariable(value="id") UUID id, Flights99PlanesRecordDto flights99PlanesRecordDto){
		Optional<Flights99Planes> flights99Planes = flights99PlanesRepository.findById(id);
		if(flights99Planes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found.");
		}
		var Flights99Planes = flights99Planes.get();
		BeanUtils.copyProperties(flights99PlanesRecordDto, Flights99Planes);
		return flights99PlanesRepository.save(Flights99Planes);
		
	}
	
	public Object updateFlightPatch(@PathVariable(value="id") UUID id, Flights99PlanesPatchRecordDto flights99PlanesPatchRecordDto){
		Optional<Flights99Planes> flights99Planes = flights99PlanesRepository.findById(id);
		if(flights99Planes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found.");
		}
		var Flights99Planes = flights99Planes.get();
		BeanUtils.copyProperties(flights99PlanesPatchRecordDto, Flights99Planes);
		return flights99PlanesRepository.save(Flights99Planes);
		
	}
	
	public Object deleteFlight(@PathVariable(value="id") UUID id){
		Optional<Flights99Planes> flights99Planes = flights99PlanesRepository.findById(id);
		if(flights99Planes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found.");
		}
		flights99PlanesRepository.delete(flights99Planes.get());
		return ResponseEntity.status(HttpStatus.OK).body("Flight Successfully Deleted.");
	}
}
