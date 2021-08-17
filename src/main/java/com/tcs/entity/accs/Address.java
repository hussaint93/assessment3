package com.tcs.entity.accs;

public class Address {
 private String city;
 private String state;
 private int pin;
 private String house;
 private String street;
public Address(String city, String state, int pin, String house, String street) {
	super();
	this.city = city;
	this.state = state;
	this.pin = pin;
	this.house = house;
	this.street = street;
}
@Override
public String toString() {
	return "[city=" + city + ", state=" + state + ", pin=" + pin + ", house=" + house + ", street=" + street
			+ "]";
}
 
}
