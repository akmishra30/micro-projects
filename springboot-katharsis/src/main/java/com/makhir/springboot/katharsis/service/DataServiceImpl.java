package com.makhir.springboot.katharsis.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.makhir.springboot.katharsis.model.AddressVO;
import com.makhir.springboot.katharsis.model.CustomerVo;

@Service
public class DataServiceImpl implements IDataService {
	private static final Logger log = LoggerFactory.getLogger(DataServiceImpl.class);
	private Map<Long, CustomerVo> customerVos = new HashMap<>();
	private Map<Long, AddressVO> addressVos = new HashMap<>();
	
	public DataServiceImpl() {
		
	}

	@Override
	public void deleteCustomer(Long id) {
		log.info("#### In a deleteCustomer(), customer to be deleted : -> {}", id);
		customerVos.remove(id);
	}

	@Override
	public CustomerVo saveCustomer(CustomerVo vo) {
		log.info("#### Saving customer with id: {}", vo.getId());
		customerVos.put(vo.getId(), vo);
		if(vo.getOfficeAddress() != null)
			addressVos.put(vo.getId(), vo.getOfficeAddress());
		log.info("#### Saved customer successfully...!!!");
		return vo;
	}

	@Override
	public Collection<CustomerVo> getCustomers() {
		log.info("#### In a getCustomers(), total customers : -> {}", customerVos.size());
		return customerVos.values();
	}

	@Override
	public CustomerVo getCustomer(Long id) {
		log.info("#### getting customer with id: {}", id);
		return customerVos.get(id);
	}

	@Override
	public void deleteAddress(Long id) {
		log.debug("##### Enter to remove address : {}", id);
		addressVos.remove(id);
	}

	@Override
	public AddressVO saveAddress(AddressVO vo) {
		log.debug("##### Enter to save address : {}", vo.getId());
		return addressVos.put(vo.getId(), vo);
	}

	@Override
	public Collection<AddressVO> getAddresses() {
		log.debug("##### Enter to get all addresses");
		return addressVos.values();
	}

	@Override
	public AddressVO getAddress(Long id) {
		log.debug("##### Getting Address vo for id : {}", id);
		return addressVos.get(id);
	}

}
