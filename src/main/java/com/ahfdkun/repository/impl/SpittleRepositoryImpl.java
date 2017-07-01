package com.ahfdkun.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ahfdkun.domain.Spittle;
import com.ahfdkun.repository.SpittleRespository;

/**
 * @Description: 
 * 
 * @author: yakun.zhao
 * 
 * @date: 2017年6月30日 下午3:26:39
 */
@Component
public class SpittleRepositoryImpl implements SpittleRespository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		List<Spittle> spittles = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			spittles.add(new Spittle("Spittle " + i, new Date(), 11.0, 11.0));
		}
		return spittles;
	}

	@Override
	public Spittle findOne(long spittleId) {
		return null;
	}

}
