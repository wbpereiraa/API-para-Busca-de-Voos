package com.william.apirest.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.william.apirest.entities.AirportAvailable;


public interface AirportAvailableRepository extends JpaRepository <AirportAvailable, UUID>{

	List<AirportAvailable> findByairportNameContainingIgnoreCase(String airportName);
	
	
}
