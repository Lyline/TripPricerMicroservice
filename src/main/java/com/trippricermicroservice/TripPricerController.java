package com.trippricermicroservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class TripPricerController {
  private final TripPricerService service;

  public TripPricerController(TripPricerService service) {
    this.service = service;
  }

  @GetMapping("/tripPricer/{apiKey}/{attractionId}/{adults}/{children}/{nightsStay}/{rewardsPoints}")
  public List<Provider> getPrice(@PathVariable("apiKey") String apiKey, @PathVariable("attractionId") UUID attractionId,
                                     @PathVariable("adults") int adults, @PathVariable("children") int children,
                                     @PathVariable("nightsStay") int nightsStay,
                                     @PathVariable("rewardsPoints") int rewardsPoints){
    return service.getPrice(apiKey, attractionId, adults, children, nightsStay, rewardsPoints);
  }
}
