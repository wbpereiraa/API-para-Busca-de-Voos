package com.william.apirest.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.RestController;

import com.william.apirest.dtos.Flights99PlanesRecordDto;
import com.william.apirest.entities.Flights99Planes;
import com.william.apirest.repositories.Flights99PlanesRepository;

import jakarta.validation.Valid;

@RestController
public class Flights99PlanesController {
	
	@Autowired
	Flights99PlanesRepository flights99PlanesRepository;
	
	@PostMapping("/99planes/newflight")
	public ResponseEntity<Flights99Planes> saveFlights(@RequestBody @Valid Flights99PlanesRecordDto flights99PlanesRecordDto){
		var flights99Planes = new Flights99Planes();
		BeanUtils.copyProperties(flights99PlanesRecordDto, flights99Planes);
		return ResponseEntity.status(HttpStatus.CREATED).body(flights99PlanesRepository.save(flights99Planes));
	}
	
	@GetMapping("/99planes/allflights")
	public ResponseEntity<List<Flights99Planes>> getAllFlights(){
		return ResponseEntity.status(HttpStatus.OK).body(flights99PlanesRepository.findAll());
	}
	
	@GetMapping("/99planes/oneflight/{id}")
	public ResponseEntity<Object> getOneFlight(@PathVariable(value="id") UUID id){
		Optional<Flights99Planes> flight = flights99PlanesRepository.findById(id);
		if(flight.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(flight.get());
	}
	
	@PutMapping("/99planes/flight/{id}")
	public ResponseEntity<Object> updateFlight(@PathVariable(value="id") UUID id, @RequestBody @Valid Flights99PlanesRecordDto flights99PlanesRecordDto){
		Optional<Flights99Planes> flight = flights99PlanesRepository.findById(id);
		if(flight.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found.");
		}
		var Flights99Planes = flight.get();
		BeanUtils.copyProperties(flights99PlanesRecordDto, Flights99Planes);
		return ResponseEntity.status(HttpStatus.OK).body(flights99PlanesRepository.save(Flights99Planes));
	}
	
	@DeleteMapping("/99planes/flight/{id}")
	public ResponseEntity<Object> deleteFlight(@PathVariable(value="id") UUID id){
		Optional<Flights99Planes> flight = flights99PlanesRepository.findById(id);
		if(flight.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found.");
		}
		flights99PlanesRepository.delete(flight.get());
		return ResponseEntity.status(HttpStatus.OK).body("Flight Successfully Deleted.");
	}
}
