package com.william.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.william.apirest.dtos.AirportAvailableRecordDto;
import com.william.apirest.entities.AirportAvailable;
import com.william.apirest.repositories.AirportAvailableRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/airports")
public class AirportAvailableController {

	@Autowired
	AirportAvailableRepository airportAvailableRepository;
	
	@PostMapping(value = "/airportavailable")
	public ResponseEntity<AirportAvailable> saveAirport(@RequestBody @Valid AirportAvailableRecordDto airportAvailableRecordDto){
		var airportAvailable = new AirportAvailable();
		BeanUtils.copyProperties(airportAvailableRecordDto, airportAvailable);
		return ResponseEntity.status(HttpStatus.CREATED).body(airportAvailableRepository.save(airportAvailable));
	}
	
	@GetMapping(value = "/airportavailable")
	public ResponseEntity<List<AirportAvailable>> getAllAirports(){
		return ResponseEntity.status(HttpStatus.OK).body(airportAvailableRepository.findAll());
	}
	
	
	@GetMapping(value = "/filter")
	public ResponseEntity<List<AirportAvailable>> findByAirport(@RequestParam("airportName")String airportName){
		 return ResponseEntity.status(HttpStatus.OK).body(airportAvailableRepository.findByairportNameContaining(airportName));
	}
	
	@PutMapping(value = "/airportavailable/{id}")
	public ResponseEntity<Object> updateAirport(@PathVariable(value="id") String airportName, @RequestBody @Valid AirportAvailableRecordDto airportAvailableRecordDto){
		Optional<AirportAvailable> airport = airportAvailableRepository.findById(airportName);
		if(airport.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Airport not found.");
		}
		var AirportAvailable = airport.get();
		BeanUtils.copyProperties(airportAvailableRecordDto, AirportAvailable);
		return ResponseEntity.status(HttpStatus.OK).body(airportAvailableRepository.save(AirportAvailable));
	}
	
	@DeleteMapping(value = "/airportavailable/{id}")
	public ResponseEntity<Object> deleteAirport(@PathVariable(value="id") String airportName){
		Optional<AirportAvailable> airport = airportAvailableRepository.findById(airportName);
		if(airport.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Airport not found.");
		}
		airportAvailableRepository.delete(airport.get());
		return ResponseEntity.status(HttpStatus.OK).body("Airport deleted sucessfuly.");
	}
}
