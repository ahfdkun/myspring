package com.ahfdkun.repository.impl;

import org.springframework.stereotype.Component;

import com.ahfdkun.domain.Spitter;
import com.ahfdkun.repository.SpitterRespository;

/**
 * @Description: 
 * 
 * @author: yakun.zhao
 * 
 * @date: 2017年6月30日 下午3:26:02
 */
@Component
public class SpitterRepositoryImpl implements SpitterRespository {

	@Override
	public Spitter save(Spitter spitter) {
		return null;
	}

	@Override
	public Spitter findByUsername(String username) {
		return new Spitter("ahfdkun", "123456", "Yakun", "Zhao");
	}

}
