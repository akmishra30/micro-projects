package com.sp.group.firends.management.service;

import com.sp.group.firends.management.entity.BaseReponse;
import com.sp.group.firends.management.entity.FriendRequest;
import com.sp.group.firends.management.entity.FriendsRequest;
import com.sp.group.firends.management.entity.FriendsResponse;
import com.sp.group.firends.management.entity.RecipientsResponse;
import com.sp.group.firends.management.entity.Subscription;
import com.sp.group.firends.management.entity.UpdateNotification;

public interface FriendsService {
	public BaseReponse createFriendsConnection(FriendsRequest request) throws Exception ;
	public FriendsResponse retrieveFriendsList(FriendRequest friend) throws Exception ;
	public FriendsResponse retrieveCommonFriends(FriendsRequest request) throws Exception ;
	public BaseReponse subscribeForUpdates(Subscription subcription) throws Exception ;
	public BaseReponse blockUpdates(Subscription subcription) throws Exception ;
	public RecipientsResponse retrieveSubscribers(UpdateNotification notification) throws Exception ;
}
