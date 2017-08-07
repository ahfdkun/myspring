package com.ahfdkun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahfdkun.domain.Spitter;
import com.ahfdkun.repository.jpa.SpitterRepository;
import com.ahfdkun.service.SpitterService;

@Service
public class SpittlerServiceImpl implements SpitterService {

	@Autowired
	private SpitterRepository spitterRepository;
	
	@Override
	public Spitter getSpitter(long id) {
		return spitterRepository.findOne(id);
	}

}
