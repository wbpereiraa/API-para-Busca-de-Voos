package com.william.apirest.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FlightsUberAirRecordDto(@NotBlank String idFlightsNumber, @NotBlank String airportOrigin, @NotBlank String airportDestiny, LocalDate data, @NotNull LocalDateTime departureTime, @NotNull LocalDateTime arrivalTime, @NotNull BigDecimal price) {

}
