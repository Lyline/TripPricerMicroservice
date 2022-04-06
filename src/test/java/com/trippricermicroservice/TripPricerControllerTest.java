package com.trippricermicroservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TripPricerController.class)
class TripPricerControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TripPricerService mockTripPricer;

  @Test
  void givenAttractionAndAdultsNumberAndChildrenNumberAndNightsStayNumberAndRewardPointsNumberWhenGetPriceThenListOfTwoProvidersWithStatus200() throws Exception {
    //Given
    Provider provider= new Provider(new UUID(1,1),"Dream travels",200.);
    Provider provider1= new Provider(new UUID(2,2),"Travel Forever",195.95);
    when(mockTripPricer.getPrice(anyString(),any(),anyInt(),anyInt(),anyInt(),anyInt())).thenReturn(Arrays.asList(provider
        ,provider1));

    //When
    mockMvc.perform(get("/tripPricer/test/cc854c69-3f64-48cf-8609-bd1d6fdaae4b/2/3/1/250"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json("[" +
            "{\"name\":\"Dream travels\",\"price\":200.0,\"tripId\":\"00000000-0000-0001-0000-000000000001\"}," +
            "{\"name\":\"Travel Forever\",\"price\":195.95,\"tripId\":\"00000000-0000-0002-0000-000000000002\"}" +
            "]"));
    //Then
  }
}