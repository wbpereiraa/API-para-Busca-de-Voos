package com.william.apirest.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.william.apirest.dtos.FlightsUberAirPatchRecordDto;
import com.william.apirest.dtos.FlightsUberAirRecordDto;
import com.william.apirest.entities.FlightsUberAir;
import com.william.apirest.repositories.FlightsUberAirRepository;

@Service
public class FlightsUberAirService {
	
	@Autowired
	private FlightsUberAirRepository flightsUberAirRepository;

	public FlightsUberAir saveFlights(FlightsUberAirRecordDto flightsUberAirRecordDto) {
		FlightsUberAir flightsUberAir = new FlightsUberAir();
		BeanUtils.copyProperties(flightsUberAirRecordDto, flightsUberAir);
		return flightsUberAirRepository.save(flightsUberAir);
	}
	
	public List<FlightsUberAir> getAllFlights(){
		return flightsUberAirRepository.findAll();
	}
	
	public Object getOneFlight(@PathVariable(value="id") UUID id){
		Optional<FlightsUberAir> flight = flightsUberAirRepository.findById(id);
		if(flight.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found.");
		}
		return flightsUberAirRepository.findById(id);
	}
	
	public List<FlightsUberAir> findByFlightsForFilters(
			@RequestParam ("airportorigin") String airportOrigin, 
			@RequestParam ("airportdestiny")String airportDestiny,
			@RequestParam ("dataflights")String dataFlights){
		LocalDate date = LocalDate.parse(dataFlights);
		return flightsUberAirRepository.findByDataFlightsAndAirportOriginAndAirportDestiny(date, airportOrigin, airportDestiny);
	}
	
	public Object updateFlight(@PathVariable(value="id") UUID id, FlightsUberAirRecordDto flightsUberAirRecordDto){
		Optional<FlightsUberAir> flightsUberAir = flightsUberAirRepository.findById(id);
		if(flightsUberAir.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found.");
		}
		var FlightsUberAir = flightsUberAir.get();
		BeanUtils.copyProperties(flightsUberAirRecordDto, FlightsUberAir);
		return flightsUberAirRepository.save(FlightsUberAir);
	}
	
	public Object updateFlightPatch(@PathVariable(value="id") UUID id, FlightsUberAirPatchRecordDto flightsUberAirPatchRecordDto){
		Optional<FlightsUberAir> flightsUberAir = flightsUberAirRepository.findById(id);
		if(flightsUberAir.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found.");
		}
		var FlightsUberAir = flightsUberAir.get();
		BeanUtils.copyProperties(flightsUberAirPatchRecordDto, FlightsUberAir);
		return flightsUberAirRepository.save(FlightsUberAir);
	}
	
	public Object deleteFlight(@PathVariable(value="id") UUID id){
		Optional<FlightsUberAir> flightsUberAir = flightsUberAirRepository.findById(id);
		if(flightsUberAir.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found.");
		}
		flightsUberAirRepository.delete(flightsUberAir.get());
		return ResponseEntity.status(HttpStatus.OK).body("Flight Successfully Deleted.");
	}
}
