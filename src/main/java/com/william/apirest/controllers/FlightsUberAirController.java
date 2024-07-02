package com.william.apirest.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
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
import com.william.apirest.repositories.AirportAvailableRepository;
import com.william.apirest.repositories.Flights99PlanesRepository;
import com.william.apirest.repositories.FlightsUberAirRepository;

import jakarta.validation.Valid;

@RestController
public class FlightsUberAirController {

	@Autowired
	FlightsUberAirRepository flightsUberAirRepository;
	@Autowired
	AirportAvailableRepository airportAvailableRepository;
	@Autowired
	Flights99PlanesRepository flights99PlanesRepository;
	
	
	@PostMapping("/flightsuberair/newflight")
	public ResponseEntity<FlightsUberAir> saveFlights(@RequestBody @Valid FlightsUberAirRecordDto flightsUberAirRecordDto){
		var flightsUberAir = new FlightsUberAir();
		BeanUtils.copyProperties(flightsUberAirRecordDto, flightsUberAir);
		return ResponseEntity.status(HttpStatus.CREATED).body(flightsUberAirRepository.save(flightsUberAir));
	}
	
	@GetMapping("/flightsuberair/allflights")
	public ResponseEntity<List<FlightsUberAir>> getAllFlights(){
		return ResponseEntity.status(HttpStatus.OK).body(flightsUberAirRepository.findAll());
	}
	
	@GetMapping("/flightsuberair/oneflight/{id}")
	public ResponseEntity<Object> getOneFlight(@PathVariable(value="id") UUID id){
		Optional<FlightsUberAir> flight = flightsUberAirRepository.findById(id);
		if(flight.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(flight.get());
	}
	
	@GetMapping(value = "/flightsuberair/airportOrigin/airportDestiny/dataFlights")
	public ResponseEntity<List<FlightsUberAir>> findByFlightsForFilters( 
			@RequestParam ("airportorigin") String airportOrigin, 
			@RequestParam ("airportdestiny")String airportDestiny,
			@RequestParam ("dataflights")String dataFlights){
		LocalDate date = LocalDate.parse(dataFlights);
		 return ResponseEntity.status(HttpStatus.OK).body(flightsUberAirRepository.findByDataFlightsAndAirportOriginAndAirportDestiny(date, airportOrigin, airportDestiny));
	}
	
	@PutMapping("/flightsuberair/flight/{id}")
	public ResponseEntity<Object> updateFlight(@PathVariable(value="id") UUID id, @RequestBody @Valid FlightsUberAirRecordDto flightsUberAirRecordDto){
		Optional<FlightsUberAir> flight = flightsUberAirRepository.findById(id);
		if(flight.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found.");
		}
		var FlightsUberAir = flight.get();
		BeanUtils.copyProperties(flightsUberAirRecordDto, FlightsUberAir);
		return ResponseEntity.status(HttpStatus.OK).body(flightsUberAirRepository.save(FlightsUberAir));
	}
	
	@PatchMapping("/flightsuberair/flight/{id}")
	public ResponseEntity<Object> updateFlightPach(@PathVariable(value="id") UUID id, @RequestBody @Valid FlightsUberAirPatchRecordDto flightsUberAirPatchRecordDto ){
		Optional<FlightsUberAir> flight = flightsUberAirRepository.findById(id);
		if(flight.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found.");
		}
		var FlightsUberAir = flight.get();
		BeanUtils.copyProperties(flightsUberAirPatchRecordDto, FlightsUberAir);
		return ResponseEntity.status(HttpStatus.OK).body(flightsUberAirRepository.save(FlightsUberAir));
	}
	
	@DeleteMapping("/flightsuberair/flight/{id}")
	public ResponseEntity<Object> deleteFlight(@PathVariable(value="id") UUID id){
		Optional<FlightsUberAir> flight = flightsUberAirRepository.findById(id);
		if(flight.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found.");
		}
		flightsUberAirRepository.delete(flight.get());
		return ResponseEntity.status(HttpStatus.OK).body("Flight deleted sucessfuly.");
	}
}
