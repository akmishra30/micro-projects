package com.makhir.springboot.katharsis.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;
import io.katharsis.resource.annotations.LookupIncludeBehavior;
import io.katharsis.resource.annotations.SerializeType;

@JsonApiResource(type = "cars")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Car {
	@JsonApiId
	private Long id;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String menufacturar;
	
	@JsonApiRelation(lookUp=LookupIncludeBehavior.AUTOMATICALLY_WHEN_NULL, serialize=SerializeType.LAZY, opposite = "car")
	private Model model;

	
	public Car() {
		
	}
	
	public Car(Long id) {
		this.id = id;
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

	public String getMenufacturar() {
		return menufacturar;
	}

	public void setMenufacturar(String menufacturar) {
		this.menufacturar = menufacturar;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", menufacturar=" + menufacturar + ", model=" + model + "]";
	}
}
