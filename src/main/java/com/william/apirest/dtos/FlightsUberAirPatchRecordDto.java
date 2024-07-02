package com.william.apirest.dtos;

import java.math.BigDecimal;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;

public record FlightsUberAirPatchRecordDto(@NotNull LocalTime departureTime, @NotNull LocalTime arrivalTime, @NotNull BigDecimal price) {

}