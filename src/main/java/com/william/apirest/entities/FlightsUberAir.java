package com.william.apirest.entities;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "flightsUberAir")
public class FlightsUberAir implements Serializable{
	
	
	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "chave")
	private UUID id;
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
