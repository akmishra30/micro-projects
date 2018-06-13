package com.sp.group.firends.management.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sp.group.firends.management.entity.ConnectionsVO;

@Repository
public interface ConnectionsRepository extends CrudRepository<ConnectionsVO, Long>{
	@Query(value = "select c from connections c where c.pid= :p_id and c.fid= :f_id")
	public ConnectionsVO findByPidAndFid(@Param("p_id") long p_id, @Param("f_id")long f_id);
	
	@Transactional
	@Query(value = "update connections c set c.block = :block where c.pid= :p_id and c.fid= :f_id")
	public void blockFriend(@Param("p_id") long p_id, @Param("f_id") long f_id, @Param("block") boolean block);
	
}
