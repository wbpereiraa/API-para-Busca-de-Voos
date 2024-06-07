package com.william.apirest.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.william.apirest.entities.FlightsUberAir;

@Repository
public interface FlightsUberAirRepository extends JpaRepository<FlightsUberAir, UUID> {

}
