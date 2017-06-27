package com.ahfdkun.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ahfdkun.aop.TrackCounter;
import com.ahfdkun.springconfig.SpringJavaConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringJavaConfig.class)
@ActiveProfiles("prod")
public class TrackCounterTest {

	@Autowired
	private CompactDisc cd;
	
	@Autowired
	private TrackCounter counter;
	
	@Test
	public void testTrackCounter() {
		cd.playTrack(1);
		cd.playTrack(1);
		cd.playTrack(1);
		cd.playTrack(1);
		cd.playTrack(1);
		
		assertEquals(5, counter.getPlayCount(1));
	}
}
