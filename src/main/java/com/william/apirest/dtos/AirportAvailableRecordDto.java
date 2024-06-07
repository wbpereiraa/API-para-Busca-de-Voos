package com.william.apirest.dtos;

import jakarta.validation.constraints.NotBlank;

public record AirportAvailableRecordDto(@NotBlank String airportName, @NotBlank String airportAbbreviation, @NotBlank String airportCity) {

}
