package com.trippricermicroservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tripPricer.TripPricer;

@Configuration
public class Config {

  @Bean
  public TripPricer getTripPricer(){return new tripPricer.TripPricer();}
}
