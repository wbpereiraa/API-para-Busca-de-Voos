package com.william.apirest.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "flights99planes")
public class Flights99Planes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	private String idFlightsNumber;
	private String airportOrigin;
	private String airportDestiny;
	private LocalDate data;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private BigDecimal price;
	
	public Flights99Planes() {
		
	}

	public Flights99Planes(UUID id, String idFlightsNumber, String airportOrigin, String airportDestiny, LocalDate data,
			LocalDateTime departureTime, LocalDateTime arrivalTime, BigDecimal price) {
		super();
		this.id = id;
		this.idFlightsNumber = idFlightsNumber;
		this.airportOrigin = airportOrigin;
		this.airportDestiny = airportDestiny;
		this.data = data;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.price = price;
	}

	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}

	public String getIdFlightsNumber() {
		return idFlightsNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setIdFlightsNumber(String idFlightsNumber) {
		this.idFlightsNumber = idFlightsNumber;
	}

	public String getAirportOrigin() {
		return airportOrigin;
	}

	public void setAirportOrigin(String airportOrigin) {
		this.airportOrigin = airportOrigin;
	}

	public String getAirportDestiny() {
		return airportDestiny;
	}

	public void setAirportDestiny(String airportDestiny) {
		this.airportDestiny = airportDestiny;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flights99Planes other = (Flights99Planes) obj;
		return Objects.equals(id, other.id);
	}
}
