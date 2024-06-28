package com.william.apirest.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.william.apirest.entities.FlightsUberAir;

@Repository
public interface FlightsUberAirRepository extends JpaRepository<FlightsUberAir, String> {
	
	List<FlightsUberAir> findByDataFlightsAndAirportOriginAndAirportDestiny(LocalDate dataFlights, String airportOrigin, String airportDestiny);

}
