package com.makhir.springboot.katharsis;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.makhir.springboot.katharsis.model.CustomerVo;

import io.katharsis.client.KatharsisClient;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryV2;

@Component
public class KatharsisAppClient {
	private static final Logger log = LoggerFactory.getLogger(KatharsisClient.class);
	
	private ResourceRepositoryV2<CustomerVo, Long> resourceRepository;
	
	@PostConstruct
	public void init(){
		log.debug("Enter: init() -------------------- ");
		KatharsisClient client = new KatharsisClient("http://localhost:9090/makhir/api");
		resourceRepository = client.getRepositoryForType(CustomerVo.class);
		log.debug("Exit: init() -------------------- ");
	}
	
	public CustomerVo findOne(Long id){
		CustomerVo vo = resourceRepository.findOne(id, new QuerySpec(CustomerVo.class));
		log.debug("KatharsisAppClient found info : {}", vo.toString());
		return vo;
	}
	
	
	public List<CustomerVo> findAll(){
		List<CustomerVo> list = resourceRepository.findAll(new QuerySpec(CustomerVo.class));
		return list;
	}
	
	public boolean delete(Long id){
		boolean status = false;
		try{
			resourceRepository.delete(id);
			status = true;
		} catch(Exception e){
			log.error("KatharsisAppClient.delete: Exception -- {}", e);
			status = false;
		}
		return status;
	}
	
	public void create(CustomerVo vo){
		resourceRepository.create(vo);
	}
	
	public void update(CustomerVo vo){
		resourceRepository.save(vo);
	}
}
