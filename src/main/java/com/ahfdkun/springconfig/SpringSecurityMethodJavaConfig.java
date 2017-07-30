package com.ahfdkun.springconfig;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * @Description 启用基于注解的方法安全性
 *
 * @author zhaoyakun
 *
 * @date 2017年7月9日 上午12:30:10
 */
@Configuration
// 启用基于注解的方法安全性
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SpringSecurityMethodJavaConfig extends GlobalMethodSecurityConfiguration {

	public static Logger log = Logger.getLogger(SpringSecurityMethodJavaConfig.class);
	
}