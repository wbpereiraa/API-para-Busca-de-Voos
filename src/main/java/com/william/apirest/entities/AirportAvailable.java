package com.william.apirest.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "airportAvailable")
public class AirportAvailable implements Serializable {


	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String airportName;
	private String airportAbbreviation;
	private String airportCity;
	
	public AirportAvailable(UUID id, String airportName, String airportAbbreviation, String airportCity) {
		super();
		this.airportName = airportName;
		this.airportAbbreviation = airportAbbreviation;
		this.airportCity = airportCity;
		this.id = id;
	}
	
	public AirportAvailable() {
		
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
