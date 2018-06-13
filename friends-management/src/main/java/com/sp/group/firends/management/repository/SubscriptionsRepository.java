package com.sp.group.firends.management.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sp.group.firends.management.entity.SubscriptionVO;

@Repository
public interface SubscriptionsRepository extends CrudRepository<SubscriptionVO, Long>{
	@Query(value = "select s from subscriptions s where s.pid= :p_id and s.fid= :f_id")
	public SubscriptionVO findByPidAndFid(@Param("p_id") long p_id, @Param("f_id")long f_id);
	
	@Transactional
	@Modifying
	@Query(value = "delete from subscriptions s where s.pid= :p_id and s.fid= :f_id")
	public void deleteByPIdAndFId(@Param("p_id") long p_id, @Param("f_id")long f_id);
}
