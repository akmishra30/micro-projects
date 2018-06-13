package com.sp.group.firends.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sp.group.firends.management.entity.FriendVO;

@Repository
public interface FriendsRepository extends CrudRepository<FriendVO, Long>{
	
	@Query(value = "select p from friends p where p.email in :emails")
	public List<FriendVO> findByEmails(@Param("emails") List<String> emails);
	
	public FriendVO findByEmail(String email);
}
