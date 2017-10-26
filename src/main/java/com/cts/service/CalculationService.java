package com.cts.service;

import com.cts.pojo.Journey;
import com.cts.pojo.Vehicle;

public interface CalculationService {
    public Integer getJourneyDistance(String fromCity,String toCity);
    public Integer getRatePerKM(Vehicle vehicle);
    public Integer calculateJourneyFair(Integer distance,Integer ratePerKM);
}
