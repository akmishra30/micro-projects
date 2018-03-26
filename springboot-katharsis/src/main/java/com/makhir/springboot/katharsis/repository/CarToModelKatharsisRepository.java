package com.makhir.springboot.katharsis.repository;

import org.springframework.stereotype.Component;

import com.makhir.springboot.katharsis.model.Car;
import com.makhir.springboot.katharsis.model.Model;

import io.katharsis.repository.RelationshipRepositoryBase;

@Component
public class CarToModelKatharsisRepository extends RelationshipRepositoryBase<Car, Long, Model, Long>{
	
	protected CarToModelKatharsisRepository() {
		super(Car.class, Model.class);
	}

}
