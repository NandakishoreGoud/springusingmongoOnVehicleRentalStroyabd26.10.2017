package com.cts.controller;

import com.cts.pojo.Bus;
import com.cts.pojo.Journey;
import com.cts.pojo.Vehicle;
import com.cts.pojo.XUV;
import com.cts.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class TestController {


    @Autowired
    CalculationService service;



    @RequestMapping(value = {"/","/vehicle_form"})
    public String vehicleForm(Model model) {
        model.addAttribute("command", new Vehicle());
        return "hello";
    }// -> /WEB-INF/view/hello.jsp


    @RequestMapping(value = "/rate_per_KM")
    public String registerUser(@ModelAttribute("command") Vehicle vehicle,Model model) {
    Integer ratePerKM=service.getRatePerKM(vehicle);
    model.addAttribute("som",ratePerKM);
    System.out.println(ratePerKM);
    return "index";
    }

    @RequestMapping(value = {"/journey_form"})
    public String journeyForm(Model model) {
        model.addAttribute("command",new Journey());
        return "journey";
    }


    @RequestMapping(value = {"/distance_cal"})
    public String calculateDistance(@ModelAttribute("command") Journey journey,Model model) {
        Integer distance=service.getJourneyDistance(journey.getFromCity(),journey.getToCity());
        model.addAttribute("distance",distance);
        return "distance";
    }


    @RequestMapping(value = "/distance/{fromCity}/{toCity}",method = RequestMethod.GET)
    @ResponseBody
    public Integer getDistance(@PathVariable("fromCity") String fromCity, @PathVariable("toCity") String toCity){
        Integer distance=service.getJourneyDistance(fromCity,toCity);
        return distance;
    }

    @RequestMapping(value = "/rate_per_km/{nameOfVehicle}/{fuelType}/{isAC}",method = RequestMethod.GET)
    @ResponseBody
    public Integer getRatePerKM(@PathVariable("nameOfVehicle") String nameOfVehicle, @PathVariable("fuelType") String fuelType,@PathVariable("isAC") String isAC){
      Vehicle vehicle=new Vehicle(nameOfVehicle,fuelType,isAC);
        Integer ratePerKM=service.getRatePerKM(vehicle);
        return ratePerKM;

    }

    @RequestMapping(value = "/car/{nameOfVehicle}/{fuelType}/{isAC}/{fromCity}/{toCity}",method = RequestMethod.GET)
    @ResponseBody
    public Integer CarJourneyFair(@PathVariable("nameOfVehicle") String nameOfVehicle, @PathVariable("fuelType") String fuelType,@PathVariable("isAC") String isAC,@PathVariable("fromCity") String fromCity, @PathVariable("toCity") String toCity){
        Vehicle vehicle=new Vehicle(nameOfVehicle,fuelType,isAC);
        Integer ratePerKM=service.getRatePerKM(vehicle);
        Integer distance=service.getJourneyDistance(fromCity,toCity);
        return service.calculateJourneyFair(distance,ratePerKM);
    }


    @RequestMapping(value = "/bus/{nameOfVehicle}/{isAC}/{fromCity}/{toCity}",method = RequestMethod.GET)
    @ResponseBody
    public Integer BusJourneyRent(@PathVariable("nameOfVehicle") String nameOfVehicle,@PathVariable("isAC") String isAC,@PathVariable("fromCity") String fromCity, @PathVariable("toCity") String toCity){
        Vehicle vehicle=new Bus(nameOfVehicle,isAC);
        Integer ratePerKM=service.getRatePerKM(vehicle);
        Integer distance=service.getJourneyDistance(fromCity,toCity);
        return service.calculateJourneyFair(distance,ratePerKM);
    }

    @RequestMapping(value = "/xuv/{nameOfVehicle}/{fromCity}/{toCity}",method = RequestMethod.GET)
    @ResponseBody
    public Integer XUVJourneyRent(@PathVariable("nameOfVehicle") String nameOfVehicle,@PathVariable("fromCity") String fromCity, @PathVariable("toCity") String toCity){
        Vehicle vehicle=new XUV(nameOfVehicle);
        Integer ratePerKM=service.getRatePerKM(vehicle);
        Integer distance=service.getJourneyDistance(fromCity,toCity);
        return service.calculateJourneyFair(distance,ratePerKM);
    }
}

