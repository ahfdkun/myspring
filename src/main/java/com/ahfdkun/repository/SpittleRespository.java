package com.ahfdkun.repository;

import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;

import com.ahfdkun.domain.Spittle;

public interface SpittleRespository {

	// @PostFilter("filterObject.message == 'Spittle 2'") // 过滤返回结果集
	List<Spittle> findSpittles(long max, int count);

	// @Secured("ROLE_SPITTER") // 接口方法生效
	// @PreAuthorize("(hasRole('ROLE_SPITTER') and #spittleId == 2) or hasRole('ROLE_PREMIUM')") // 执行方法前校验
	// @PostAuthorize("returnObject.message == principal.username") // 方法执行后校验
	Spittle findOne(long spittleId);

	Spittle save(Spittle spittle);
	
	@PreFilter("hasPermission(filterObject, 'java.lang.Long', 'read')") // 筛选形参列表值
	void remove(List<Long> spittleIds);
	
}
