package com.ahfdkun.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Repository;

import com.ahfdkun.domain.Spittle;
import com.ahfdkun.exception.web.DuplicateSpittleException;
import com.ahfdkun.repository.SpittleRespository;
import com.ahfdkun.service.AlertService;

/**
 * @Description: 
 * 
 * @author: yakun.zhao
 * 
 * @date: 2017年6月30日 下午3:26:39
 */
@Repository
public class SpittleRepositoryImpl implements SpittleRespository {
	
	@Autowired
	private AlertService alertService;

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		List<Spittle> spittles = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			spittles.add(new Spittle("Spittle " + i, new Date(), 11.0, 11.0));
		}
		return spittles;
	}

	// @Cacheable("spittleCache") // 只是当前实现类会生效Cache
	// @RolesAllowed("ROLE_SPITTER") // 接口不生效
	public Spittle findOne(long spittleId) {
		Spittle spittle = new Spittle("ahfdkun", new Date(), 100.0, 200.1);
		alertService.sendSpittleAlert(spittle); // 异步发送消息
		return spittle;
	}

	@CachePut(value = "spittleCache", key = "#result.id", unless = "#result.message.contains('abc')")
	@Secured("ROLE_SPITTER")
	public Spittle save(Spittle spittle) {
		spittle.setId(2L);
		if (spittle.getId() == null) {
			throw new DuplicateSpittleException();
		}
		spittle = alertService.receiveSpittleAlert(); // 同步接收消息
		System.out.println("JMS接收到的Spittle: " + spittle);
		return spittle;
	}

	@CacheEvict("spittleCache") // 删除缓存，名称为‘spittleCache’
	public void remove(List<Long> spittleIds) {
		System.out.println("spittleIds removed: " + spittleIds);
	}

}
