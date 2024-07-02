package com.william.apirest.dtos;

import java.math.BigDecimal;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;

public record Flights99PlanesPatchRecordDto(@NotNull LocalTime departureTime, @NotNull LocalTime arrivalTime, @NotNull BigDecimal price) {

}