package com.makhir.springboot.katharsis.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.makhir.springboot.katharsis.model.AddressVO;
import com.makhir.springboot.katharsis.model.CustomerVo;
import com.makhir.springboot.katharsis.service.IDataService;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;

@Component
public class CustomerKatharsisRepository extends ResourceRepositoryBase<CustomerVo,	Long>{
	private static final Logger log = LoggerFactory.getLogger(CustomerKatharsisRepository.class);
	
	@Autowired
	private IDataService dataService;
	
	protected CustomerKatharsisRepository() {
		super(CustomerVo.class);
	}

	@Override
	public synchronized <S extends CustomerVo> S save(S resource) {
		dataService.saveCustomer(resource);
		if(resource.getOfficeAddress() != null)
			dataService.saveAddress(resource.getOfficeAddress());
		log.debug("##### CustomerVo Save successfully...!!");
		return resource;
	}
	
	@Override
	public ResourceList<CustomerVo> findAll(QuerySpec querySpec) {
		log.debug("Enter: CustomerKatharsisRepository.findAll");
		
		ResourceList<CustomerVo> list = querySpec.apply(dataService.getCustomers());
		
		log.debug("## Total no. of customers : {}", list.size());
		
		log.debug("Exit: CustomerKatharsisRepository.findAll");
		
		return list;
	}
	
	@Override
	public CustomerVo findOne(Long id, QuerySpec querySpec) {
		log.debug("Enter: CustomerKatharsisRepository.findOne");
		log.debug("Finding a customer : {}", id);
		
		//CustomerVo vo = super.findOne(id, querySpec);
		CustomerVo vo = dataService.getCustomer(id);
		
		AddressVO addressVO = dataService.getAddress(id);
		if(addressVO != null)
			vo.setOfficeAddress(addressVO);
		
		//log.debug("Customer found : {}", vo.toString());
		
		log.debug("Exit: CustomerKatharsisRepository.findOne");
		return vo;
	}
	
	@Override
	public synchronized void delete(Long id) {
		log.debug("Enter: CustomerKatharsisRepository.delete");
		dataService.deleteCustomer(id);
		dataService.deleteAddress(id);
		log.debug("Exit: CustomerKatharsisRepository.delete");
	}
}
