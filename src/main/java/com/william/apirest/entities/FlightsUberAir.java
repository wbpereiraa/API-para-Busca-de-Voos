package com.william.apirest.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "flightsUberAir")
public class FlightsUberAir{
	
	@Id
	@Column(name = "voo")
	private String idFlightsNumber;
	@Column(name = "origem")
	private String airportOrigin;
	@Column(name = "destino")
	private String airportDestiny;
	@Column(name = "data_saida")
	private LocalDate dataFlights;
	@Column(name = "saida")
	private LocalTime departureTime;
	@Column(name = "chegada")
	private LocalTime arrivalTime;
	@Column(name = "valor")
	private BigDecimal price;
	
	public FlightsUberAir() {
		
	}

	public FlightsUberAir(String idFlightsNumber, String airportOrigin, String airportDestiny, LocalDate dataFlights,
			LocalTime departureTime, LocalTime arrivalTime, BigDecimal price) {
		super();
		this.idFlightsNumber = idFlightsNumber;
		this.airportOrigin = airportOrigin;
		this.airportDestiny = airportDestiny;
		this.dataFlights = dataFlights;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.price = price;
	}

	public String setIdFlightsNumber() {
		return idFlightsNumber;
	}

	public String getIdFlightsNumber() {
		return idFlightsNumber;
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
		return dataFlights;
	}

	public void setData(LocalDate dataFlights) {
		this.dataFlights = dataFlights;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
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
		return Objects.hash(idFlightsNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightsUberAir other = (FlightsUberAir) obj;
		return Objects.equals(idFlightsNumber, other.idFlightsNumber);
	}
}
