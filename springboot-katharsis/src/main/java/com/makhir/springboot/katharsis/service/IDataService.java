package com.makhir.springboot.katharsis.service;

import java.util.Collection;

import com.makhir.springboot.katharsis.model.AddressVO;
import com.makhir.springboot.katharsis.model.CustomerVo;

public interface IDataService {
	public void deleteCustomer(Long id);
	public CustomerVo saveCustomer(CustomerVo vo);
	public Collection<CustomerVo> getCustomers();
	public CustomerVo getCustomer(Long id);
	
	public void deleteAddress(Long id);
	public AddressVO saveAddress(AddressVO vo);
	public Collection<AddressVO> getAddresses();
	public AddressVO getAddress(Long id);
	
}
