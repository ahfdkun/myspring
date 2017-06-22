package com.ahfdkun.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ahfdkun.domain.NotePad;
import com.ahfdkun.springconfig.SpringJavaConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringJavaConfig.class)
@ActiveProfiles("prod")
public class ScopePrototypeTest {

	@Autowired
	private NotePad notepad;
	
	@Autowired
	private NotePad notepad1;
	
	@Test
	public void test() {
		System.out.println(notepad == notepad1);
	}

}
