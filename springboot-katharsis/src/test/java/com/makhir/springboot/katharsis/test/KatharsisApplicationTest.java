package com.makhir.springboot.katharsis.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.makhir.springboot.katharsis.KatharsisAppClient;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class KatharsisApplicationTest {
	
	@Autowired
	KatharsisAppClient katharsisAppClient;
	
	
	
	@Test
	public void testFindOne(){
		assertThat(katharsisAppClient.findOne(1L).getName()).isEqualTo("Ashking");
	}
	
	@Test
	public void testFindAll(){
		assertThat(katharsisAppClient.findAll().size()).isGreaterThan(0);
	}
	
	@Test
	public void testDelete(){
		assertThat(katharsisAppClient.delete(1L)).isTrue();
	}
}
