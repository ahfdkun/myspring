package com.ahfdkun.repository;

import java.util.List;

import com.ahfdkun.domain.Spittle;

public interface SpittleRespository {

	List<Spittle> findSpittles(long max, int count);

	Spittle findOne(long spittleId);
	
}
