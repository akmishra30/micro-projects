package com.sp.group.firends.management.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.group.firends.management.entity.BaseReponse;
import com.sp.group.firends.management.entity.ConnectionsVO;
import com.sp.group.firends.management.entity.FriendRequest;
import com.sp.group.firends.management.entity.FriendVO;
import com.sp.group.firends.management.entity.FriendsRequest;
import com.sp.group.firends.management.entity.FriendsResponse;
import com.sp.group.firends.management.entity.MessageVO;
import com.sp.group.firends.management.entity.RecipientsResponse;
import com.sp.group.firends.management.entity.Subscription;
import com.sp.group.firends.management.entity.SubscriptionVO;
import com.sp.group.firends.management.entity.UpdateNotification;
import com.sp.group.firends.management.exception.FriendProfileNotFoundException;
import com.sp.group.firends.management.repository.ConnectionsRepository;
import com.sp.group.firends.management.repository.FriendsRepository;
import com.sp.group.firends.management.repository.MessagesRepository;
import com.sp.group.firends.management.repository.SubscriptionsRepository;
import com.sp.group.firends.management.validation.ValidationUtil;

@Service
public class FriendsServiceImpl implements FriendsService{
	private static final Logger logger = LoggerFactory.getLogger(FriendsServiceImpl.class);

	@Autowired
	private FriendsRepository friendsRepository;
	
	@Autowired
	private ConnectionsRepository connectionsRepository;
	
	@Autowired
	private MessagesRepository messagesRepository;
	
	@Autowired
	private SubscriptionsRepository subscriptionsRepository;
	
	public FriendsServiceImpl(FriendsRepository repository, ConnectionsRepository connectionsRepository, 
			MessagesRepository messagesRepository, SubscriptionsRepository subscriptionsRepository){
		this.friendsRepository = repository;
		this.connectionsRepository = connectionsRepository;
		this.messagesRepository = messagesRepository;
		this.subscriptionsRepository = subscriptionsRepository;
	}
	
	@Transactional
	public BaseReponse createFriendsConnection(FriendsRequest request) throws Exception{
		logger.info("Enter: createFriendsConnection");
		BaseReponse reponse = null;
		
		List<FriendVO> list = verifyFriendsProfile(request.getFriends());
		
		FriendVO f1 = list.get(0), f2 = list.get(1);
		addConnection(f1, f2);
		addConnection(f2, f1);
		reponse = new BaseReponse(true);
		
		logger.info("Exit: createFriendsConnection");
		return reponse;
	}
	
	public FriendsResponse retrieveFriendsList(FriendRequest friend) throws Exception {
		logger.info("Enter: retrieveFriendsList");
		FriendsResponse response = null;
		FriendVO vo = friendsRepository.findByEmail(friend.getEmail());
		
		if(vo == null)
			throw new FriendProfileNotFoundException("Given friend is not available.");
		else {
			response = new FriendsResponse(true, vo.getConnections().stream().map(obj -> obj.getEmail()).collect(Collectors.toList()));
		}
		logger.info("Exit: retrieveFriendsList");
		return response;
	}
	
	/**
	 * This method retrieves the common connection between two friends.
	 * 
	 * */
	public FriendsResponse retrieveCommonFriends(FriendsRequest request) throws Exception {
		logger.info("Enter: retrieveCommonFriends");
		FriendsResponse response = null;
		
		List<FriendVO> list = verifyFriendsProfile(request.getFriends());
		
		response = new FriendsResponse(true, getCommonEmails(list.get(0), list.get(1)));
		
		logger.info("Exit: retrieveCommonFriends");
		return response;
	}
	
	/**
	 * This method creates the subscription between two friends.
	 * 
	 * */
	public BaseReponse subscribeForUpdates(Subscription subcription) throws Exception {
		logger.info("Enter: subscribeForUpdates");
		logger.info("Subscribed Subscription entity: ", subcription.toString());
		
		BaseReponse reponse = new BaseReponse();
		
		List<FriendVO> list = verifyFriendsProfile(Arrays.asList(subcription.getRequestor(), subcription.getTarget()));
		
		FriendVO f1 = list.get(0), f2 = list.get(1);
		
		if(f1.getEmail().equalsIgnoreCase(subcription.getRequestor()))
			addSubscription(f1, f2);
		else
			addSubscription(f2, f1);
		
		reponse.setSuccess(true);
		logger.info("Exit: subscribeForUpdates");
		return reponse;
	}

	/**
	 * This methods blocks the updates between two friends
	 * */
	@Transactional
	public BaseReponse blockUpdates(Subscription subcription) throws Exception {
		logger.info("Blocked Subscription entity : ", subcription.toString());
		
		List<FriendVO> list = verifyFriendsProfile(Arrays.asList(subcription.getRequestor(), subcription.getTarget()));
		
		FriendVO f1 = list.get(0), f2 = list.get(1);
		
		if(f1.getEmail().equalsIgnoreCase(subcription.getRequestor()))
			subscriptionsRepository.deleteByPIdAndFId(f1.getId(), f2.getId());
		else
			subscriptionsRepository.deleteByPIdAndFId(f2.getId(), f1.getId());
		
		return new BaseReponse(true);
	}

	@Transactional
	public RecipientsResponse retrieveSubscribers(UpdateNotification notification) throws Exception {
		logger.info("Enter : retrieveSubscribers");
		logger.info("RetrieveSubscribers : ", notification.toString());
		Set<String> subscribers = new HashSet<String>();
		
		FriendVO friendVo = friendsRepository.findByEmail(notification.getSender());
		
		if(friendVo == null)
			throw new FriendProfileNotFoundException("Given friend is not available.");
		else {
			subscribers.addAll(friendVo.getSubscribers().stream().map(obj -> obj.getEmail()).collect(Collectors.toList()));
			subscribers.addAll(friendVo.getConnections().stream().map(obj -> obj.getEmail()).collect(Collectors.toList()));
		}
		
		MessageVO vo = new MessageVO(friendVo.getId(), notification.getText());
		messagesRepository.save(vo);
		
		subscribers.addAll(ValidationUtil.extractEmailsFromText(notification.getText()));
		
		logger.info("Exit : retrieveSubscribers");
		return new RecipientsResponse(true, new ArrayList<String>(subscribers));
	}
	
	@Transactional
	private void addConnection(FriendVO f1, FriendVO f2){
		logger.info("Enter: addConnection");
		if(connectionsRepository.findByPidAndFid(f1.getId(), f2.getId()) == null){
			connectionsRepository.save(new ConnectionsVO(f1.getId(), f2.getId(), false));
			logger.info("Connected successfully.");
		} else
			logger.info("Already in connections");
		logger.info("Exit: addConnection");
	}
	
	@Transactional
	private void addSubscription(FriendVO f1, FriendVO f2){
		logger.info("Enter: addSubscription");
		if(subscriptionsRepository.findByPidAndFid(f1.getId(), f2.getId()) == null){
			subscriptionsRepository.save(new SubscriptionVO(f1.getId(), f2.getId(), false));
			logger.info("Subscribed successfully.");
		} else
			logger.info("Already subscribed.");
		logger.info("Exit: addSubscription");
	}
	
	@Transactional
	private void blockFriend(FriendVO f1, FriendVO f2){
		logger.info("Enter: addConnection");
		if(connectionsRepository.findByPidAndFid(f1.getId(), f2.getId()) == null){
			connectionsRepository.save(new ConnectionsVO(f1.getId(), f2.getId(), false));
			logger.info("Connected successfully.");
		} else
			logger.info("Already in connections");
		logger.info("Exit: addConnection");
	}
	
	/**
	 * This method verifies the friends profile is present or not. Based on that it will returns the list of friends
	 * or throws an exception.
	 * */
	private List<FriendVO> verifyFriendsProfile(List<String> emails) throws Exception{
		logger.info("Enter: verifyFriendsProfile");
		List<FriendVO> list = friendsRepository.findByEmails(emails);
		List<String> tmpList = new ArrayList<>();
		tmpList.addAll(emails);
		
		for (FriendVO personVO : list) {
			if(tmpList.contains(personVO.getEmail())){
				tmpList.remove(personVO.getEmail());
			}
		}
		
		if(tmpList.size() > 0){
			logger.error("There is an error while verifying profiles.");
			StringBuilder error = new StringBuilder();
			error.append(emails.toString()).append(" profile(s) were not found.");
			throw new FriendProfileNotFoundException(error.toString());
		}
		logger.info("Profiles {} has been verified successfully. ", list.toString());
		logger.info("Exit: verifyFriendsProfile");
		return list;
	}
	
	/**
	 * This method returns the common emails between two friends.
	 * 
	 * */
	private List<String> getCommonEmails(FriendVO f1, FriendVO f2){
		List<String> emails = new ArrayList<>();
		List<String> common = new ArrayList<>();
		
		for(FriendVO vo : f1.getConnections())
			emails.add(vo.getEmail());
		
		for(FriendVO vo : f2.getConnections()){
			if(emails.contains(vo.getEmail()))
				common.add(vo.getEmail());
		}
		
		return common;
	}
	
}
