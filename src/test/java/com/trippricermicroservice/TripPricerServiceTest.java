package com.trippricermicroservice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class TripPricerServiceTest {

  private final tripPricer.TripPricer mockTripPricer= mock(tripPricer.TripPricer.class);

  private final TripPricerService classUnderTest= new TripPricerService(mockTripPricer);

  @Test
  void givenAttractionAndAdultsNumberAndChildrenNumberAndNightsStayNumberAndRewardPointsNumberWhenGetPriceThenListOfTwoProviders() {
    //Given
    tripPricer.Provider provider= new tripPricer.Provider(new UUID(1,1),"Dream travels",200.);
    tripPricer.Provider provider1= new tripPricer.Provider(new UUID(2,2),"Travel Forever",195.95);

    when(mockTripPricer.getPrice(anyString(),any(),anyInt(),anyInt(),anyInt(),anyInt())).thenReturn(Arrays.asList(provider
        ,provider1));

    //When
    List<Provider>actual= classUnderTest.getPrice("test",new UUID(8,9),
                                                  5,6,1,250);

    //Then
    assertThat(actual.size()).isEqualTo(2);
    assertThat(actual.get(0).name).isEqualTo("Dream travels");
    assertThat(actual.get(1).name).isEqualTo("Travel Forever");

    verify(mockTripPricer,times(1)).getPrice("test",new UUID(8,9),
                                                                    5,6,1,250);
  }
}