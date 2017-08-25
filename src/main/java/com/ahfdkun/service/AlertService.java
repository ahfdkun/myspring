package com.ahfdkun.service;

import com.ahfdkun.domain.Spittle;

public interface AlertService {

	void sendSpittleAlert(Spittle spittle);

	Spittle receiveSpittleAlert();
	
}
