package com.ahfdkun.repository;

import java.util.List;

import com.ahfdkun.domain.Spittle;

public interface SpittleRespository {

	List<Spittle> findSpittles(long max, int count);

	// @Secured("ROLE_SPITTER") // 接口方法生效
	Spittle findOne(long spittleId);

	Spittle save(Spittle spittle);
	
	public void remove(long spittleId);
	
}
