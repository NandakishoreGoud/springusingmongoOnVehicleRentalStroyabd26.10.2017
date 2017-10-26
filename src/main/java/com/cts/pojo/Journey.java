package com.cts.pojo;

public class Journey {
	private String fromCity;
	private String toCity;

	public Journey() {
	}

	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public Journey(String fromCity, String toCity) {
		super();
		this.fromCity = fromCity;
		this.toCity = toCity;
	}
	
	

}
