package com.cts.pojo;

public  class Vehicle {
   private String nameOfVehicle;
   private String fuelType;
   private String isAc;


    public Vehicle() {
    }

    public Vehicle(String nameOfVehicle, String fuelType, String isAc) {
        this.nameOfVehicle = nameOfVehicle;
        this.fuelType = fuelType;
        this.isAc = isAc;
    }

    public void setNameOfVehicle(String nameOfVehicle) {
        this.nameOfVehicle = nameOfVehicle;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setIsAc(String isAc) {
        this.isAc = isAc;
    }

    public String getNameOfVehicle() {
        return nameOfVehicle;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getIsAc() {
        return isAc;
    }
}
