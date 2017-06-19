package com.ahfdkun.service;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ahfdkun.springconfig.SpringJavaConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringJavaConfig.class)
@ActiveProfiles("prod")
public class TestMyService {

	@Autowired
	private HashMap<String, String> hashmap;
	
	@Test
	public void testmap() {
		System.out.println(hashmap);
	}
}
