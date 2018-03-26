package com.makhir.springboot.katharsis.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "addresses")
public class AddressVO implements Serializable{
	private static final long serialVersionUID = 1L;
	@JsonApiId
	private Long id;
	@JsonProperty
	private String unit;
	@JsonProperty
	private String floor;
	@JsonProperty
	private String block;
	@JsonProperty
	private String street;
	@JsonProperty
	private String area;
	@JsonProperty
	private String city;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String country;
	private int pin;
	
	
	public AddressVO() {
	}
	
	public AddressVO(Long id, String unit, String floor, String block, String street, String area, String city, String country,
			int pin) {
		super();
		this.id = id;
		this.unit = unit;
		this.floor = floor;
		this.block = block;
		this.street = street;
		this.area = area;
		this.city = city;
		this.country = country;
		this.pin = pin;
	}


	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}

	
	@Override
	public String toString() {
		return "AddressVO [id=" + id + ", unit=" + unit + ", floor=" + floor + ", block=" + block + ", street=" + street
				+ ", area=" + area + ", city=" + city + ", country=" + country + ", pin=" + pin + "]";
	}
	
	
}
