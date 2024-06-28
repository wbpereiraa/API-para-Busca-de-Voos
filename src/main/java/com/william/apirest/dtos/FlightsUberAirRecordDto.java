package com.william.apirest.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FlightsUberAirRecordDto(String idFlightsNumber, @NotBlank String airportOrigin, @NotBlank String airportDestiny, @NotNull LocalDate dataFlights, @NotNull LocalTime departureTime, @NotNull LocalTime arrivalTime, @NotNull BigDecimal price) {

}
