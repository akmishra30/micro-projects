package com.sp.group.firends.management.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.group.firends.management.entity.BaseReponse;
import com.sp.group.firends.management.entity.FriendRequest;
import com.sp.group.firends.management.entity.FriendsRequest;
import com.sp.group.firends.management.entity.FriendsResponse;
import com.sp.group.firends.management.entity.RecipientsResponse;
import com.sp.group.firends.management.entity.Subscription;
import com.sp.group.firends.management.entity.UpdateNotification;
import com.sp.group.firends.management.service.FriendsService;
import com.sp.group.firends.management.validation.ValidationUtil;

@RestController
@RequestMapping(path = "/api/friends", 
	produces = MediaType.APPLICATION_JSON_VALUE,
	consumes = MediaType.APPLICATION_JSON_VALUE)
public class FriendsManagementController {
	private static final Logger logger = LoggerFactory.getLogger(FriendsManagementController.class);

	@Autowired
	private FriendsService friendsService;
	
	public FriendsManagementController(FriendsService friendsService){
		this.friendsService = friendsService;
	}
	
	@PutMapping(path = "/add/connection")
	public BaseReponse createFriendConnection(@Valid @RequestBody FriendsRequest request) throws Exception {
		ValidationUtil.validateEmailList(request.getFriends());
		return friendsService.createFriendsConnection(request);
	}

	@PostMapping(path = "/retrieve/list")
	public FriendsResponse retrieveFriendsList(@Valid @RequestBody FriendRequest friend) throws Exception {
		logger.info("Retrieving retrieveFriendsList : ", friend.toString());
		
		return friendsService.retrieveFriendsList(friend);
	}

	@PostMapping(path = "/retrieve/common")
	public FriendsResponse retrieveCommanFriends(@Valid @RequestBody FriendsRequest request) throws Exception {
		logger.info("Retrieving common friend list : ", request.toString());
		ValidationUtil.validateEmailList(request.getFriends());
		return friendsService.retrieveCommonFriends(request);
	}

	@PutMapping(path = "/subscribe/updates")
	public BaseReponse subscribeForUpdates(@Valid @RequestBody Subscription subcription) throws Exception {
		logger.info("Requested Subscription : ", subcription.toString());
		return friendsService.subscribeForUpdates(subcription);
	}

	@DeleteMapping(path = "/block/updates")
	public BaseReponse blockUpdates(@Valid @RequestBody Subscription subcription) throws Exception {
		logger.info("Blocked Subscription : ", subcription.toString());
		return friendsService.blockUpdates(subcription);
	}

	@PostMapping(path = "/send/updates")
	public RecipientsResponse retrieveSubscribers(@Valid @RequestBody UpdateNotification notification) throws Exception {
		logger.info("UpdateNotification  : ", notification.toString());
		return friendsService.retrieveSubscribers(notification);
	}
}
