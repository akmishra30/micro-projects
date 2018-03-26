package com.makhir.springboot.katharsis.model;

import java.beans.Transient;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "models")
public class Model implements Serializable{
	private static final long serialVersionUID = 1L;

	@JsonApiId
	private Long id;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String year;
	
	@JsonProperty
	private String varient;
	
	@JsonProperty
	private Long carid;
	
	@JsonIgnore
	private Car car;

	public Model(Long id) {
		this.id = id;
	}

	public Model() {
		
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	public String getVarient() {
		return varient;
	}



	public void setVarient(String varient) {
		this.varient = varient;
	}

	public Long getCarid() {
		return carid;
	}

	public void setCarid(Long carid) {
		this.carid = carid;
	}
	
	

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Model [id=" + id + ", name=" + name + ", year=" + year + ", varient=" + varient + ", carid=" + carid
				+ "]";
	}

	
}
