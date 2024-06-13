package com.william.apirest.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Flights99PlanesRecordDto(String idFlightsNumber, @NotBlank String airportOrigin, @NotBlank String airportDestiny, LocalDate dataFlights, @NotNull LocalTime departureTime, @NotNull LocalTime arrivalTime, @NotNull BigDecimal price) {

}
