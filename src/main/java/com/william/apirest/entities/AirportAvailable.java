package com.william.apirest.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "airportAvailable")
public class AirportAvailable {

	@Id
	private String airportName;
	private String airportAbbreviation;
	private String airportCity;
	
	public AirportAvailable() {
		
	}
	
	public AirportAvailable(String airportName, String airportAbbreviation, String airportCity) {
		super();
		this.airportName = airportName;
		this.airportAbbreviation = airportAbbreviation;
		this.airportCity = airportCity;
	}
	
	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportAbbreviation() {
		return airportAbbreviation;
	}

	public void setAirportAbbreviation(String airportAbbreviation) {
		this.airportAbbreviation = airportAbbreviation;
	}

	public String getAirportCity() {
		return airportCity;
	}

	public void setAirportCity(String airportCity) {
		this.airportCity = airportCity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(airportName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirportAvailable other = (AirportAvailable) obj;
		return Objects.equals(airportName, other.airportName);
	}
}
