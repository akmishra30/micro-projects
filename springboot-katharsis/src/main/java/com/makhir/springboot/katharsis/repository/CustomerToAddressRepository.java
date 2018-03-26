package com.makhir.springboot.katharsis.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.makhir.springboot.katharsis.model.AddressVO;
import com.makhir.springboot.katharsis.model.CustomerVo;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.RelationshipRepositoryBase;
import io.katharsis.resource.list.ResourceList;

@Component
public class CustomerToAddressRepository extends RelationshipRepositoryBase<CustomerVo, Long, AddressVO, Long>{
	private static final Logger log = LoggerFactory.getLogger(CustomerToAddressRepository.class);

	protected CustomerToAddressRepository() {
		super(CustomerVo.class, AddressVO.class);
	}
	
	@Override
	public void addRelations(CustomerVo source, Iterable<Long> targetIds, String fieldName) {
		log.debug("Enter: findManyTargets() -- {}, {}", source, fieldName);
		log.debug("Enter: CustomerToAddressRepository.addRelations()");
	}
	
	@Override
	public void setRelation(CustomerVo source, Long targetId, String fieldName) {
		log.debug("Enter: setRelation() -- {}, {}", targetId, fieldName);
		log.debug("Enter: CustomerToAddressRepository.setRelation()");
	}
	
	@Override
	public void setRelations(CustomerVo source, Iterable<Long> targetIds, String fieldName) {
		log.debug("Enter: setRelations() -- {}, {}", targetIds, fieldName);
		log.debug("Enter: CustomerToAddressRepository.setRelation()");
	}
	
	@Override
	public AddressVO findOneTarget(Long sourceId, String fieldName, QuerySpec querySpec) {
		log.debug("Enter: CustomerToAddressRepository.findOneTarget()");
		log.debug("Enter: findOneTarget() -- {}, {}", fieldName, sourceId);
		return super.findOneTarget(sourceId, fieldName, querySpec);
	}
	
	@Override
	public ResourceList<AddressVO> findManyTargets(Long sourceId, String fieldName, QuerySpec querySpec) {
		log.debug("Enter: CustomerToAddressRepository.findManyTargets()");
		log.debug("Enter: findManyTargets() -- {}, {}", fieldName, sourceId);
		return super.findManyTargets(sourceId, fieldName, querySpec);
	}
}
