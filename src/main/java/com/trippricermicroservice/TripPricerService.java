package com.trippricermicroservice;

import org.springframework.stereotype.Service;
import tripPricer.TripPricer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TripPricerService {

  private final tripPricer.TripPricer tripPricer;

  public TripPricerService(TripPricer tripPricer) {
    this.tripPricer = tripPricer;
  }

  public List<Provider> getPrice(String apiKey, UUID attractionId, int adults, int children,
                                 int nightsStay, int rewardsPoints){
    List<Provider>providers= new ArrayList<>();
    List<tripPricer.Provider> tripPricerProviders= tripPricer.getPrice(apiKey, attractionId, adults, children,
        nightsStay,
        rewardsPoints);

    for (tripPricer.Provider p:tripPricerProviders){
      Provider provider=new Provider(p.tripId,p.name,p.price);
      providers.add(provider);
    }

    return providers;
  }
}
