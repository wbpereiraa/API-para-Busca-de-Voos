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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.william.apirest.dtos.FlightsUberAirPatchRecordDto;
import com.william.apirest.dtos.FlightsUberAirRecordDto;
import com.william.apirest.entities.FlightsUberAir;
import com.william.apirest.repositories.FlightsUberAirRepository;
import com.william.apirest.service.ServiceFlightsUberAir;

import jakarta.validation.Valid;

@RestController
public class FlightsUberAirController {

	@Autowired
	FlightsUberAirRepository flightsUberAirRepository;
	
	@Autowired
	ServiceFlightsUberAir service;
	
	
	@PostMapping("/flightsuberair/newflight")
	public ResponseEntity<FlightsUberAir> saveFlights(@RequestBody @Valid FlightsUberAirRecordDto flightsUberAirRecordDto){
		FlightsUberAir flightsUberAir = service.saveFlights(flightsUberAirRecordDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(flightsUberAir);
	}
	
	@GetMapping("/flightsuberair/allflights")
	public ResponseEntity<List<FlightsUberAir>> getAllFlights(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllFlights());
	}
	
	@GetMapping("/flightsuberair/oneflight/{id}")
	public ResponseEntity<Object> getOneFlight(@PathVariable(value="id") UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(service.getOneFlight(id));
	}
	
	@GetMapping("/flightsuberair/airportOrigin/airportDestiny/dataFlights")
	public ResponseEntity<List<FlightsUberAir>> findByFlightsForFilters(@RequestParam String airportOrigin, @RequestParam String airportDestiny, @RequestParam String dataFlights){
		 return ResponseEntity.status(HttpStatus.OK).body(service.findByFlightsForFilters(airportOrigin, airportDestiny, dataFlights));
	}
	
	@PutMapping("/flightsuberair/flight/{id}")
	public ResponseEntity<Object> updateFlight(@PathVariable(value="id") UUID id, @RequestBody @Valid FlightsUberAirRecordDto flightsUberAirRecordDto){
		return ResponseEntity.status(HttpStatus.OK).body(service.updateFlight(id, flightsUberAirRecordDto));
	}
	
	@PatchMapping("/flightsuberair/flight/{id}")
	public ResponseEntity<Object> updateFlightPach(@PathVariable(value="id") UUID id, @RequestBody @Valid FlightsUberAirPatchRecordDto flightsUberAirPatchRecordDto ){
		return ResponseEntity.status(HttpStatus.OK).body(service.updateFlightPatch(id, flightsUberAirPatchRecordDto));
	}
	
	@DeleteMapping("/flightsuberair/flight/{id}")
	public ResponseEntity<Object> deleteFlight(@PathVariable(value="id") UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(service.deleteFlight(id));
	}
}
