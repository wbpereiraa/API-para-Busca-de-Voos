package com.william.apirest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.william.apirest.dtos.Flights99PlanesPatchRecordDto;
import com.william.apirest.dtos.Flights99PlanesRecordDto;
import com.william.apirest.entities.Flights99Planes;
import com.william.apirest.repositories.Flights99PlanesRepository;
import com.william.apirest.service.ServiceFlights99Planes;

import jakarta.validation.Valid;

@RestController
public class Flights99PlanesController {
	
	@Autowired
	Flights99PlanesRepository flights99PlanesRepository;
	
	@Autowired
	ServiceFlights99Planes service;
	
	@PostMapping("/99planes/newflight")
	public ResponseEntity<Flights99Planes> saveFlights(@RequestBody @Valid Flights99PlanesRecordDto flights99PlanesRecordDto){
		Flights99Planes flights99Planes = service.saveFlights(flights99PlanesRecordDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(flights99Planes);
	}
	
	@GetMapping("/99planes/allflights")
	public ResponseEntity<List<Flights99Planes>> getAllFlights(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllFlights());
	}
	
	@GetMapping("/99planes/oneflight/{id}")
	public ResponseEntity<Object> getOneFlight(@PathVariable(value="id") UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(service.getOneFlight(id));
	}
	
	@PutMapping("/99planes/flight/{id}")
	public ResponseEntity<Object> updateFlight(@PathVariable(value="id") UUID id, @RequestBody @Valid Flights99PlanesRecordDto flights99PlanesRecordDto){
		return ResponseEntity.status(HttpStatus.OK).body(service.updateFlight(id, flights99PlanesRecordDto));
	}
	
	@PatchMapping("/99planes/flight/{id}")
	public ResponseEntity<Object> updateFlightPatch(@PathVariable(value="id") UUID id, @RequestBody @Valid Flights99PlanesPatchRecordDto flights99PlanesPatchRecordDto ){
		return ResponseEntity.status(HttpStatus.OK).body(service.updateFlightPatch(id, flights99PlanesPatchRecordDto));
	}
	
	@DeleteMapping("/99planes/flight/{id}")
	public ResponseEntity<Object> deleteFlight(@PathVariable(value="id") UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(service.deleteFlight(id));
	}
}
