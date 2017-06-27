package com.ahfdkun.service.impl;

import org.springframework.stereotype.Component;

import com.ahfdkun.service.CompactDisc;

@Component
public class SgtPeppers implements CompactDisc {

	private String title = "Sgt. Peppers Lonely Heart Club Band";
	private String artist = "The Beatles";
	
	public void playTrack(int trackNum) {
		System.out.println("Playing " + title + " by " + artist + ", trackNum: " + trackNum);
	}

}
