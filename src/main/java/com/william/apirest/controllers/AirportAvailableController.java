package com.william.apirest.controllers;

import java.util.List;
import java.util.UUID;

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
import com.william.apirest.service.AirportAvailableService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/airports")
public class AirportAvailableController {

	@Autowired
	AirportAvailableRepository airportAvailableRepository;
	
	@Autowired
	AirportAvailableService service;
	
	@PostMapping(value = "/newairportavailable")
	public ResponseEntity<AirportAvailable> saveAirport(@RequestBody @Valid AirportAvailableRecordDto airportAvailableRecordDto){
		AirportAvailable airportAvailable = service.saveAirport(airportAvailableRecordDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(airportAvailable);
	}
	
	@GetMapping(value = "/allairportavailable")
	public ResponseEntity<List<AirportAvailable>> getAllAirports(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllAirports());
	}
	
	@GetMapping(value = "/filter/airportname")
	public ResponseEntity<List<AirportAvailable>> findByAirport(@RequestParam("airportName")String airportName){
		 return ResponseEntity.status(HttpStatus.OK).body(service.findByAirport(airportName));
	}
	
	@PutMapping(value = "/airportavailable/{id}")
	public ResponseEntity<Object> updateAirport(@PathVariable(value="id") UUID id, @RequestBody @Valid AirportAvailableRecordDto airportAvailableRecordDto){
		return ResponseEntity.status(HttpStatus.OK).body(service.updateAirport(id, airportAvailableRecordDto));
	}
	
	@DeleteMapping(value = "/airportavailable/{id}")
	public ResponseEntity<Object> deleteAirport(@PathVariable(value="id") UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(service.deleteAirport(id));
	}
}
