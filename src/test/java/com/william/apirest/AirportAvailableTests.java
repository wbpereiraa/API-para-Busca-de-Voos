package com.william.apirest;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.william.apirest.controllers.AirportAvailableController;
import com.william.apirest.dtos.AirportAvailableRecordDto;
import com.william.apirest.entities.AirportAvailable;
import com.william.apirest.repositories.AirportAvailableRepository;
import com.william.apirest.service.AirportAvailableService;



@SpringBootTest
public class AirportAvailableTests {


    private static final UUID ID = UUID.randomUUID();
    private static final Integer index   = 0;
	private static final String airportName = "Aeroporto Internacional de guarulhos";
	private static final String airportAbreviation = "AIG";
	private static final String airportCity = "Guarulhos SP";
	
    @InjectMocks
    private AirportAvailableService service;
    
	@Mock
	private AirportAvailableRepository airportAvailableRepository;
    
	private AirportAvailable airportAvailable;
	private AirportAvailableRecordDto airportAvailableRecordDto;
	private Optional<AirportAvailable> optionalAirportAvailable;
	
    @BeforeEach
    void setUp() {
    	
    	MockitoAnnotations.openMocks(this);
    	startAirportAvailable();
    }

    @Test
    @DisplayName("Teste que retorna os aeroportos cadastrados por nome")
    void testReturnSucessAllAirports() throws Exception {
        when(airportAvailableRepository.findByairportNameContainingIgnoreCase(airportName)).thenReturn(List.of(airportAvailable));
        
        List<AirportAvailable> response = service.findByAirport(airportName);
        
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(AirportAvailable.class, response.get(index).getClass());
        
        assertEquals(ID, response.get(index).getId());
        assertEquals(airportName, response.get(index).getAirportName());
        assertEquals(airportAbreviation, response.get(index).getAirportAbbreviation());
        assertEquals(airportCity, response.get(index).getAirportCity());
    }
    
    private void startAirportAvailable() {
    	airportAvailable = new AirportAvailable(ID, airportName, airportAbreviation, airportCity);
    	optionalAirportAvailable = Optional.of(new AirportAvailable(ID, airportName, airportAbreviation, airportCity));
    }
}

