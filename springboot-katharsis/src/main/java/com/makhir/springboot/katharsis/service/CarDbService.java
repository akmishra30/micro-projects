package com.makhir.springboot.katharsis.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makhir.springboot.katharsis.db.DbCustomRepository;
import com.makhir.springboot.katharsis.model.Car;
import com.makhir.springboot.katharsis.model.Model;

@Service
public class CarDbService implements ICarDbService{
	private static final Logger log = LoggerFactory.getLogger(CarDbService.class); 
	
	@Autowired
	DbCustomRepository dbRepository;
	
	@Override
	public void saveCar(Car vo) {
		log.debug("Enter: CarDbService.save(), {}", vo.toString());
		
		log.debug("Exit: CarDbService.save()");
	}

	@Override
	public Car getCar(Long id) {
		log.debug("Enter: CarDbService.getCar(), {}", id);
		Car vo = dbRepository.getCar(new Car(id));
		log.debug("Exit: CarDbService.getCar(), {}", vo.toString());
		return vo;
	}

	@Override
	public List<Car> getCars() {
		log.debug("Enter: CarDbService.getCars()");
		List<Car> list = dbRepository.getCars();
		log.debug("Exit: CarDbService.getCars()");
		return list;
	}

	@Override
	public void deleteCar(Car vo) {
		log.debug("Enter: CarDbService.delete()");
		
		log.debug("Exit: CarDbService.delete()");
	}

	@Override
	public void saveModel(Model vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Model getModel(Model vo) {
		log.debug("Enter: CarDbService.getModel(), {}", vo.toString());
		Model resVo = dbRepository.getModel(vo);
		log.debug("Exit: CarDbService.getModel(), {}", resVo.toString());
		return resVo;
	}

	@Override
	public List<Model> getModels(Model vo) {
		log.debug("Enter: CarDbService.getModels(), {}", vo);
		
		List<Model> resVo = dbRepository.getModels(vo);
		
		log.debug("Exit: CarDbService.getModels(), {}", resVo.toString());
		return resVo;
	}

	@Override
	public void deleteModel(Model vo) {
		// TODO Auto-generated method stub
		
	}
}
