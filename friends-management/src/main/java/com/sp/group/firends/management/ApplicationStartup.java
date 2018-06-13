package com.sp.group.firends.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is an application startup class. This class runs the friends management API server
 * by running spring-boot embedded tomcat server which initialize and exposed the APIs.
 * 
 * @author Ashish Mishra
 * */

@SpringBootApplication
public class ApplicationStartup {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationStartup.class, args);
	}
}
