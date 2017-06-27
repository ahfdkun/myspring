package com.ahfdkun.service.impl;

import org.springframework.stereotype.Component;

import com.ahfdkun.service.Performance;

@Component
public class Woodstock implements Performance {

	@Override
	public void perform() {
		System.out.println("Woodstock...");
	}

}
