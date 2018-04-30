package com.phone;

public class Address {
	private int houseNum;
	private String street;
	private String City;
	private String state;
	private String zip;

	// Contractor for address
	public Address(String street, String city, String state, String zip) {
		this.street = street;
		City = city;
		this.state = state;
		this.zip = zip;
	}

	// get house num
	public int getHouseNum() {
		return houseNum;
	}

	// set house num
	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}

	// get street
	public String getStreet() {
		return street;
	}

	// set street
	public void setStreet(String street) {
		this.street = street;
	}

	// get city name
	public String getCity() {
		return City;
	}

	// set city name
	public void setCity(String city) {
		City = city;
	}

	// get state
	public String getState() {
		return state;
	}

	// set state name
	public void setState(String state) {
		this.state = state;
	}

	// get zip code
	public String getZip() {
		return zip;
	}

	// set zip code
	public void setZip(String zip) {
		this.zip = zip;
	}
	//return address 
	public String toString() {
		
		return "Address: "+this.street+", "+ this.City+", "+this.state+", "+ this.zip;
	}

}
