package com.makhir.springboot.katharsis.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;
import io.katharsis.resource.annotations.LookupIncludeBehavior;
import io.katharsis.resource.annotations.SerializeType;


@JsonApiResource(type = "customers")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerVo implements Serializable{
	private static final long serialVersionUID = 1L;

	@JsonApiId
	private long id;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String city;
	
	@JsonProperty
	private long mobile;
	
	@JsonProperty("officeAddress")
	@JsonApiRelation(lookUp=LookupIncludeBehavior.AUTOMATICALLY_WHEN_NULL, serialize=SerializeType.LAZY, opposite = "customer")
	private AddressVO officeAddress;
	
	public CustomerVo(){
		super();
	}
	
	public CustomerVo(long id){
		this.id = id;
	}
	
	public CustomerVo(long id, String name){
		this.id = id;
		this.name= name;
	}
	
	public CustomerVo(long id, String name, String city, long mobile, AddressVO officeAddress){
		this.id = id;
		this.name= name;
		this.city = city;
		this.mobile = mobile;
		this.officeAddress = officeAddress;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	public AddressVO getOfficeAddress() {
		return officeAddress;
	}
	
	public void setOfficeAddress(AddressVO officeAddress) {
		this.officeAddress = officeAddress;
	}
}
