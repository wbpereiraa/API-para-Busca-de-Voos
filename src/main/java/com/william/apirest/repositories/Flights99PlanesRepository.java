package com.william.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.william.apirest.entities.Flights99Planes;

@Repository
public interface Flights99PlanesRepository extends JpaRepository<Flights99Planes, String> {

}
