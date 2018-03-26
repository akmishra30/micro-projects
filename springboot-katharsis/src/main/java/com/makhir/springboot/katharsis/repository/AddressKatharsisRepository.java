package com.makhir.springboot.katharsis.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.makhir.springboot.katharsis.model.AddressVO;
import com.makhir.springboot.katharsis.service.IDataService;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;

@Component
public class AddressKatharsisRepository extends ResourceRepositoryBase<AddressVO, Long>{
	private static final Logger log = LoggerFactory.getLogger(AddressKatharsisRepository.class);
	
	@Autowired
	private IDataService dataService;
	
	protected AddressKatharsisRepository() {
		super(AddressVO.class);
	}
	
	@Override
	public synchronized <S extends AddressVO> S save(S resource) {
		log.debug("Enter: AddressKatharsisRepository.save");
		dataService.saveAddress(resource);
		log.debug("#####AddressVO Save successfully...!!");
		return null;
	}

	@Override
	public ResourceList<AddressVO> findAll(QuerySpec querySpec) {
		log.debug("Enter: AddressKatharsisRepository.findAll");
		
		ResourceList<AddressVO> list = querySpec.apply(dataService.getAddresses());
		
		log.debug("## Total no. of address : {}", list.size());
		
		log.debug("Exit: AddressKatharsisRepository.findAll");
		
		return list;
	}
	
	@Override
	public AddressVO findOne(Long id, QuerySpec querySpec) {
		log.debug("Enter: AddressKatharsisRepository.findOne, id : {}", id);
		
		AddressVO vo = dataService.getAddress(id);
		
		if(vo != null)
			log.debug("#### Address VO : {} ", vo.toString());
			
		log.debug("Exit: AddressKatharsisRepository.findOne, {}", vo);
		return vo;
	}
	
	@Override
	public synchronized void delete(Long id) {
		log.debug("Enter: AddressKatharsisRepository.delete");
		log.debug("Deleting a address : {}", id);
		dataService.deleteAddress(id);
		log.debug("Address deleted successfully : {}", id);
		
		log.debug("Exit: AddressKatharsisRepository.delete");
	}
}
