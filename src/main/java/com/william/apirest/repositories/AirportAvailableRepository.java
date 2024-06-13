package com.william.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.william.apirest.entities.AirportAvailable;

@Repository
public interface AirportAvailableRepository extends JpaRepository <AirportAvailable, String>{

}
