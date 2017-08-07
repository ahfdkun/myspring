package com.ahfdkun.springconfig;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import net.sf.ehcache.CacheManager;

/**
 * @Description 启用EhCache缓存 
 *
 * @author zhaoyakun
 *
 * @date 2017年7月27日 下午9:05:40
 */
//@Configuration
// 启用缓存
//@EnableCaching
public class SpringEhCacheJavaConfig {

	@Bean
	public EhCacheCacheManager cacheManager(CacheManager cacheManager) { // 声明缓存管理器
		return new EhCacheCacheManager(cacheManager);
	}
	
	@Bean
	public EhCacheManagerFactoryBean ehcache() { // EhCache的CacheManager实现
		EhCacheManagerFactoryBean ehManagerFactoryBean = new EhCacheManagerFactoryBean();
		ehManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		return ehManagerFactoryBean;
	}
	
}
	