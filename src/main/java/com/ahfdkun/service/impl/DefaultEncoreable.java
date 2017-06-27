package com.ahfdkun.service.impl;

import com.ahfdkun.service.Encoreable;

public class DefaultEncoreable implements Encoreable {

	@Override
	public void performEncore() {
		System.out.println("DefaultEncoreable performEncore()...");
	}

}
