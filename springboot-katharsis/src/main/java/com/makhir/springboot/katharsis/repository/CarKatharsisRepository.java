package com.makhir.springboot.katharsis.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.makhir.springboot.katharsis.model.Car;
import com.makhir.springboot.katharsis.service.CarDbService;
import com.makhir.springboot.katharsis.service.ICarDbService;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;

@Component
public class CarKatharsisRepository extends ResourceRepositoryBase<Car, Long> {
	private static final Logger log = LoggerFactory.getLogger(CarDbService.class); 
	
	@Autowired
	ICarDbService carDbService;
	
	protected CarKatharsisRepository() {
		super(Car.class);
	}

	
	@Override
	public ResourceList<Car> findAll(QuerySpec querySpec) {
		
		log.debug("Enter: CarKatharsisRepository.findAll");
		
		List<Car> list = carDbService.getCars();
		
		log.debug("### Total no. of cars founds : {}", list.size());
		
		log.debug("Exit: CarKatharsisRepository.findAll");
		
		return querySpec.apply(list);
	}

	@Override
	public Car findOne(Long id, QuerySpec querySpec) {
		log.debug("Enter: CarKatharsisRepository.findOne -- {}", id);
		
		Car vo = carDbService.getCar(id);
		
		log.debug("Exit: CarKatharsisRepository.findOne -- {}", id);
		return vo;
	}
	
	@Override
	public void delete(Long id) {
		log.debug("Enter: CarKatharsisRepository.delete -- {}", id);
		
		Car vo = new Car();
		vo.setId(id);
		
		carDbService.deleteCar(vo);
		
		log.debug("Exit: CarKatharsisRepository.delete");
	}
}
