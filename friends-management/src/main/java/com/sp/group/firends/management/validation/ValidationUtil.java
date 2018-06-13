package com.sp.group.firends.management.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sp.group.firends.management.exception.DataValidationException;

public class ValidationUtil {
	public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
	
	/**
	 * This method validates the email list and throw an exception when there will be a invalid emails.
	 * 
	 * */
	public static void validateEmailList(List<String> emails) throws DataValidationException{
		List<String> invalidEmails = new ArrayList<>();
		for (String email : emails) {
			if(!email.matches(EMAIL_REGEX))
				invalidEmails.add(email);
		}
		if(invalidEmails.size() > 0)
			throw new DataValidationException(invalidEmails.toString() + " emails are invalid.");
	}
	
	/**
	 * This method extracts the valid email addresses from given text.
	 * 
	 * */
	public static List<String> extractEmailsFromText(String text){
		List<String> emails = new ArrayList<String>();
		Matcher emailFinder = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(text);
		
		while(emailFinder.find()){
			String email = emailFinder.group();
			if(email.matches(EMAIL_REGEX))
				emails.add(email);
		}
		return emails;
	}
}
