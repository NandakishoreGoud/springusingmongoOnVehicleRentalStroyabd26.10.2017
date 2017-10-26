package com.cts.service;

import org.springframework.stereotype.Service;
import com.cts.dao.DistanceDao;
import com.cts.pojo.Bus;
import com.cts.pojo.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class CalculationServiceImpl implements  CalculationService{




    @Autowired
    DistanceDao distanceDao;


    @Override
    public Integer getJourneyDistance(String fromCity,String toCity){
        return distanceDao.getDistanceByCityName(fromCity)+distanceDao.getDistanceByCityName(toCity);
    }




    @Override
    public Integer getRatePerKM(Vehicle vehicle) {
        int ratePerKM = 0;
        int ratePerKMPetrol = 8;
        int ratePerKMDiesel = 9;
        int acCharge =2;
        if (vehicle.getFuelType().equalsIgnoreCase("petrol")) {
            if (vehicle.getIsAc().equalsIgnoreCase("NON-AC")) {
                ratePerKM = ratePerKMPetrol;
            } else {
                ratePerKM = ratePerKMPetrol +2;
            }
        } else {
            if (vehicle.getIsAc().equalsIgnoreCase("NON-AC")) {

                ratePerKM = ratePerKMDiesel;
            } else {
                ratePerKM = ratePerKMDiesel + 2;
            }

        }
       System.out.println(vehicle.getIsAc());
        if(vehicle instanceof Bus)
        {

            ratePerKM=(int)(ratePerKM-0.02*ratePerKM);
        }
        return ratePerKM;

    }





    @Override
    public Integer calculateJourneyFair(Integer distance, Integer ratePerKM) {
        Integer totalJourneyRent = distance * ratePerKM;
        return totalJourneyRent;
    }
}
