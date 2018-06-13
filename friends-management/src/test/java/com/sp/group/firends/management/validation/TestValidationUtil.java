package com.sp.group.firends.management.validation;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.sp.group.firends.management.exception.DataValidationException;

public class TestValidationUtil {
	private String text;
	private List<String> emails;
	
	@InjectMocks
	private ValidationUtil validationUtil;
	
	@Before
	public void initialize(){
		this.text = "Hello World! kate@example.com";
		this.emails = new ArrayList<>();
		emails.add("abc@tet.com");
		emails.add("pqr@tet.com");
		
		this.validationUtil = new ValidationUtil();
	}
	
	@After
	public void nullify(){
		this.text = null;
		this.validationUtil = null;
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testValidateEmailList() throws DataValidationException{
		try {
			validationUtil.validateEmailList(emails);
			Assert.assertTrue(emails.size() == 2);
			emails.add("abc");
			validationUtil.validateEmailList(emails);
			
		} catch (DataValidationException e) {
			Assert.assertTrue(e.getMessage().length() > 0);
		}
		
	}
	
	@Test
	public void testExtractEmailsFromText(){
		@SuppressWarnings("static-access")
		List<String> list = validationUtil.extractEmailsFromText(text);
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
	}
}
