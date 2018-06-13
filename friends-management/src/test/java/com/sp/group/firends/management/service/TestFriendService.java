package com.sp.group.firends.management.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sp.group.firends.management.entity.BaseReponse;
import com.sp.group.firends.management.entity.ConnectionsVO;
import com.sp.group.firends.management.entity.FriendRequest;
import com.sp.group.firends.management.entity.FriendVO;
import com.sp.group.firends.management.entity.FriendsRequest;
import com.sp.group.firends.management.entity.FriendsResponse;
import com.sp.group.firends.management.entity.RecipientsResponse;
import com.sp.group.firends.management.entity.Subscription;
import com.sp.group.firends.management.entity.UpdateNotification;
import com.sp.group.firends.management.repository.ConnectionsRepository;
import com.sp.group.firends.management.repository.FriendsRepository;
import com.sp.group.firends.management.repository.MessagesRepository;
import com.sp.group.firends.management.repository.SubscriptionsRepository;

@RunWith(MockitoJUnitRunner.class)
public class TestFriendService {
	
	@Autowired
	private FriendsService friendsService;
	
	@MockBean
	private FriendsRepository friendsRepository;
	
	@MockBean
	private ConnectionsRepository connectionsRepository;
	
	@MockBean
	private MessagesRepository messagesRepository;
	
	@MockBean
	private SubscriptionsRepository subscriptionsRepository;
	
	private List<FriendVO> friendList;
	private ConnectionsVO connectionVo;
	
	private FriendVO friendVo;
	
	@Before
	public void setUP(){
		this.friendsRepository = mock(FriendsRepository.class);
		this.connectionsRepository = mock(ConnectionsRepository.class);
		this.messagesRepository = mock(MessagesRepository.class);
		this.subscriptionsRepository = mock(SubscriptionsRepository.class);
		
		this.friendsService = new FriendsServiceImpl(this.friendsRepository,
				this.connectionsRepository,
				this.messagesRepository, 
				this.subscriptionsRepository);
		
		this.friendList = new ArrayList<FriendVO>();
		FriendVO f1 = new FriendVO(1, "abc@gmail.com");
		f1.setConnections(new HashSet<FriendVO>(Arrays.asList(new FriendVO(3, "pqr@gmail.com"), new FriendVO(4, "xyz@gmail.com"))));
		
		FriendVO f2 = new FriendVO(2, "xyz@gmail.com");
		f2.setConnections(new HashSet<FriendVO>(Arrays.asList(new FriendVO(3, "pqr@gmail.com"), new FriendVO(4, "xyz@gmail.com"))));
		
		friendList.add(f1);
		friendList.add(f2);
		
		this.connectionVo = new ConnectionsVO(1, 2, true);
		Mockito.when(friendsRepository.findByEmails(any())).thenReturn(this.friendList);
		Mockito.when(connectionsRepository.findByPidAndFid(1, 2)).thenReturn(this.connectionVo);
		
		friendVo = new FriendVO(1, "abc@gmail.com");
		friendVo.setConnections(new HashSet<FriendVO>(Arrays.asList(new FriendVO(3, "pqr@gmail.com"), new FriendVO(4, "xyz@gmail.com"))));
		friendVo.setSubscribers(new HashSet<FriendVO>(Arrays.asList(new FriendVO(3, "pqr@gmail.com"), new FriendVO(4, "xyz@gmail.com"))));
		
		Mockito.when(friendsRepository.findByEmail(any())).thenReturn(friendVo);
	}
	
	@After
	public void flushObjects(){
		
	}
	
	@Test
	public void testCreateFriendsConnection() throws Exception {
		FriendsRequest request = new FriendsRequest();
		request.setFriends(Arrays.asList("abc@gmail.com", "xyz@gmail.com"));
		BaseReponse response = friendsService.createFriendsConnection(request);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.isSuccess());
	} 
	
	@Test
	public void testRetrieveFriendsList() throws Exception{
		FriendRequest friend = new FriendRequest();
		friend.setEmail("abc@gmail.com");
		FriendsResponse response = friendsService.retrieveFriendsList(friend);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.isSuccess());
		Assert.assertEquals(response.getCount(), 2);
	}
	
	@Test
	public void testRetrieveCommonFriends() throws Exception{
		FriendsRequest request = new FriendsRequest();
		request.setFriends(Arrays.asList("abc@gmail.com", "xyz@gmail.com"));
		FriendsResponse response = friendsService.retrieveCommonFriends(request);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.isSuccess());
		Assert.assertEquals(response.getCount(), 2);
	}
	
	@Test
	public void testSubscribeForUpdates() throws Exception {
		Subscription subcription = new Subscription();
		subcription.setRequestor("abc@gmail.com");
		subcription.setTarget("xyz@gmail.com");
		
		BaseReponse response = friendsService.subscribeForUpdates(subcription);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.isSuccess());
		
	}
	
	@Test
	public void testBlockUpdates() throws Exception {
		Subscription subcription = new Subscription();
		subcription.setRequestor("abc@gmail.com");
		subcription.setTarget("xyz@gmail.com");
		
		BaseReponse response = friendsService.blockUpdates(subcription);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.isSuccess());
	}
	
	@Test
	public void testRetrieveSubscribers() throws Exception{
		UpdateNotification notification = new UpdateNotification();
		notification.setSender("abc@gmail.com");
		notification.setText("Hello World! kate@example.com");
		
		RecipientsResponse response = friendsService.retrieveSubscribers(notification);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.isSuccess());
	}
}
