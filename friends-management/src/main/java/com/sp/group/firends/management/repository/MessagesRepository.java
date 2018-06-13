package com.sp.group.firends.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sp.group.firends.management.entity.MessageVO;

@Repository
public interface MessagesRepository extends CrudRepository<MessageVO, Long>{
	
}
