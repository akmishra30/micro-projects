package com.sp.group.firends.management.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.sp.group.firends.management.service.FriendsService;

@RunWith(SpringRunner.class)
@ContextConfiguration
@WebMvcTest(value = { FriendsManagementController.class })
public class TestFriendsManagementController {
	private MockMvc mvc;

	@Autowired
	private WebApplicationContext context;

	@MockBean
	private FriendsService friendsService;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testAddConnection() throws Exception {
		String payload = readFileContent("add-connection.txt");

		// positive test
		MvcResult postiveResult = mvc.perform(MockMvcRequestBuilders.put("/api/friends/add/connection")
				.contentType(MediaType.APPLICATION_JSON).content(payload)).andReturn();

		int status = postiveResult.getResponse().getStatus();
		assertNotNull(postiveResult);
		assertEquals(status, HttpStatus.OK.value());

		// invalid method
		MvcResult invalid = mvc.perform(MockMvcRequestBuilders.post("/api/friends/add/connection")
				.contentType(MediaType.APPLICATION_JSON).content(payload)).andReturn();

		int inv_code = invalid.getResponse().getStatus();
		assertNotNull(invalid.getResponse().getContentAsString());
		assertEquals(inv_code, HttpStatus.INTERNAL_SERVER_ERROR.value());

		// invalid payload
		MvcResult negativeResult = mvc.perform(MockMvcRequestBuilders.put("/api/friends/add/connection")
				.contentType(MediaType.APPLICATION_JSON).content("")).andReturn();

		int code = negativeResult.getResponse().getStatus();
		assertNotNull(negativeResult.getResponse().getContentAsString());
		assertEquals(code, HttpStatus.BAD_REQUEST.value());
	}

	@Test
	public void testBlockUpdates() throws Exception {
		String payload = readFileContent("block-updates.txt");

		// positive case
		MvcResult postiveResult = mvc.perform(MockMvcRequestBuilders.delete("/api/friends/block/updates")
				.contentType(MediaType.APPLICATION_JSON).content(payload)).andReturn();

		assertNotNull(postiveResult.getResponse().getContentAsString());
		assertEquals(postiveResult.getResponse().getStatus(), HttpStatus.OK.value());

		// invalid payload - 400 BAD_REQUEST
		MvcResult invalidPayload = mvc.perform(MockMvcRequestBuilders.delete("/api/friends/block/updates")
				.contentType(MediaType.APPLICATION_JSON).content("")).andReturn();

		assertNotNull(invalidPayload.getResponse().getContentAsString());
		assertEquals(invalidPayload.getResponse().getStatus(), HttpStatus.BAD_REQUEST.value());

		// invalid method - 500 INTERNAL_SERVER_ERROR
		MvcResult internalError = mvc.perform(MockMvcRequestBuilders.post("/api/friends/block/updates")
				.contentType(MediaType.APPLICATION_JSON).content("")).andReturn();

		assertNotNull(internalError.getResponse().getContentAsString());
		assertEquals(internalError.getResponse().getStatus(), HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void testRetrieveCommons() throws Exception{
		String payload = readFileContent("retrieve-common.txt");

		// positive case
		MvcResult postiveResult = mvc.perform(MockMvcRequestBuilders.post("/api/friends/retrieve/common")
				.contentType(MediaType.APPLICATION_JSON).content(payload)).andReturn();

		assertNotNull(postiveResult.getResponse().getContentAsString());
		assertEquals(postiveResult.getResponse().getStatus(), HttpStatus.OK.value());

		// invalid payload - 400 BAD_REQUEST
		MvcResult invalidPayload = mvc.perform(MockMvcRequestBuilders.post("/api/friends/retrieve/common")
				.contentType(MediaType.APPLICATION_JSON).content("")).andReturn();

		assertNotNull(invalidPayload.getResponse().getContentAsString());
		assertEquals(invalidPayload.getResponse().getStatus(), HttpStatus.BAD_REQUEST.value());

		// invalid method - 500 INTERNAL_SERVER_ERROR
		MvcResult internalError = mvc.perform(MockMvcRequestBuilders.delete("/api/friends/retrieve/common")
				.contentType(MediaType.APPLICATION_JSON).content("")).andReturn();

		assertNotNull(internalError.getResponse().getContentAsString());
		assertEquals(internalError.getResponse().getStatus(), HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
	@Test
	public void testRetrieveList() throws Exception{
		String payload = readFileContent("retrieve-list.txt");
		String uri = "/api/friends/retrieve/list";
		// positive case
		MvcResult postiveResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON).content(payload)).andReturn();

		assertNotNull(postiveResult.getResponse().getContentAsString());
		assertEquals(postiveResult.getResponse().getStatus(), HttpStatus.OK.value());

		// invalid payload - 400 BAD_REQUEST
		MvcResult invalidPayload = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON).content("")).andReturn();

		assertNotNull(invalidPayload.getResponse().getContentAsString());
		assertEquals(invalidPayload.getResponse().getStatus(), HttpStatus.BAD_REQUEST.value());

		// invalid method - 500 INTERNAL_SERVER_ERROR
		MvcResult internalError = mvc.perform(MockMvcRequestBuilders.delete(uri)
				.contentType(MediaType.APPLICATION_JSON).content("")).andReturn();

		assertNotNull(internalError.getResponse().getContentAsString());
		assertEquals(internalError.getResponse().getStatus(), HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
	@Test
	public void testSendUpdate() throws Exception{
		String payload = readFileContent("send-updates.txt");
		String uri = "/api/friends/send/updates";

		// positive case
		MvcResult postiveResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON).content(payload)).andReturn();

		assertNotNull(postiveResult.getResponse().getContentAsString());
		assertEquals(postiveResult.getResponse().getStatus(), HttpStatus.OK.value());

		// invalid payload - 400 BAD_REQUEST
		MvcResult invalidPayload = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON).content("")).andReturn();

		assertNotNull(invalidPayload.getResponse().getContentAsString());
		assertEquals(invalidPayload.getResponse().getStatus(), HttpStatus.BAD_REQUEST.value());

		// invalid method - 500 INTERNAL_SERVER_ERROR
		MvcResult internalError = mvc.perform(MockMvcRequestBuilders.delete(uri)
				.contentType(MediaType.APPLICATION_JSON).content("")).andReturn();

		assertNotNull(internalError.getResponse().getContentAsString());
		assertEquals(internalError.getResponse().getStatus(), HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
	@Test
	public void testSubscribeUpdate() throws Exception{
		String payload = readFileContent("subscribe-updates.txt");
		String uri = "/api/friends/subscribe/updates";

		// positive case
		MvcResult postiveResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON).content(payload)).andReturn();

		assertNotNull(postiveResult.getResponse().getContentAsString());
		assertEquals(postiveResult.getResponse().getStatus(), HttpStatus.OK.value());

		// invalid payload - 400 BAD_REQUEST
		MvcResult invalidPayload = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON).content("")).andReturn();

		assertNotNull(invalidPayload.getResponse().getContentAsString());
		assertEquals(invalidPayload.getResponse().getStatus(), HttpStatus.BAD_REQUEST.value());

		// invalid method - 500 INTERNAL_SERVER_ERROR
		MvcResult internalError = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON).content("")).andReturn();

		assertNotNull(internalError.getResponse().getContentAsString());
		assertEquals(internalError.getResponse().getStatus(), HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	public String readFileContent(String fileName) {
		StringBuilder fileContent = new StringBuilder();
		File file = new File(TestFriendsManagementController.class.getClassLoader().getResource(fileName).getFile());

		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				fileContent.append(line);
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileContent.toString();
	}
}
