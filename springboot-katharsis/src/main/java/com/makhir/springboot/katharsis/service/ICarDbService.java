package com.makhir.springboot.katharsis.service;

import java.util.List;

import com.makhir.springboot.katharsis.model.Car;
import com.makhir.springboot.katharsis.model.Model;

public interface ICarDbService {
	public void saveCar(Car vo);
	public Car getCar(Long id);
	public List<Car> getCars();
	public void deleteCar(Car vo);
	
	public void saveModel(Model vo);
	public Model getModel(Model vo);
	public List<Model> getModels(Model vo);
	public void deleteModel(Model vo);
}
