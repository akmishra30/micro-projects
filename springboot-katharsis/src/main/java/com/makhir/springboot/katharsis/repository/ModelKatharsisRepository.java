package com.makhir.springboot.katharsis.repository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.makhir.springboot.katharsis.model.Car;
import com.makhir.springboot.katharsis.model.Model;
import com.makhir.springboot.katharsis.service.ICarDbService;

import io.katharsis.queryspec.FilterSpec;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;

@Component
public class ModelKatharsisRepository extends ResourceRepositoryBase<Model, Long>{
	private static final Logger log = LoggerFactory.getLogger(ModelKatharsisRepository.class);
	
	@Autowired
	ICarDbService carDbService;
	
	protected ModelKatharsisRepository() {
		super(Model.class);
	}

	@Override
	public ResourceList<Model> findAll(QuerySpec querySpec) {
		log.debug("Enter: ModelKatharsisRepository.findAll");
		
		FilterSpec filterSpec = FilterSpec.and(querySpec.getFilters());
		
		Object obj = filterSpec.getValue();
		
		Object id = ((List<ArrayList<Long>>)obj).get(0);
		
		long carId = (Long) id;
		
		Model vo = new Model();
		vo.setCarid(carId);
		
		List<Model> list = carDbService.getModels(vo);
		Car carVo = carDbService.getCar(carId);
		
		for (Model model : list) {
			model.setCar(carVo);
		}

		log.debug("### Total no. of models founds : {}", list.size());
		
		ResourceList<Model> result = querySpec.apply(list);
		
		log.debug("Exit: ModelKatharsisRepository.findAll, resultsize : {}", result.size());
		return result;
	}
	
	@Override
	public Model findOne(Long id, QuerySpec querySpec) {
		log.debug("Enter: ModelKatharsisRepository.findOne id --- : {}", id);
		
		//FilterSpec filterSpec = FilterSpec.and(querySpec.getFilters());
		
		log.debug("#### Resource class name : {}", querySpec.getResourceClass().getSimpleName());
		
		Model vo = new Model();
		vo.setId(id);
		
		Model resVo = carDbService.getModel(vo);
		
		log.debug("### Response vo founds : {}", resVo.toString());
		
		log.debug("Exit: ModelKatharsisRepository.findOne");
		
		return resVo;
	}

}
