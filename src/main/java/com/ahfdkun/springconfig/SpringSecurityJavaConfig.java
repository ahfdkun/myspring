package com.ahfdkun.springconfig;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.ahfdkun.repository.SpitterRespository;
import com.ahfdkun.service.impl.SpitterUserService;

/**
 * @Description 启用Web安全性
 *
 * @author zhaoyakun
 *
 * @date 2017年7月9日 上午12:30:10
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityJavaConfig extends WebSecurityConfigurerAdapter {

	public static Logger log = Logger.getLogger(SpringSecurityJavaConfig.class);
	
	/*@Autowired*/
	DataSource dataSource;
	
	@Autowired
	SpitterRespository spitterRespository;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		log.info("Initialization SpringSecurityJavaConfig configure....");
		// 使用基于内存用户存储进行认证
		/*auth.inMemoryAuthentication().withUser("ahfdkun").password("123").roles("USER").and().withUser("admin").password("123").roles("USER", "ADMIN");*/
		
		// 使用基于数据库表进行认证
		/*auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username,password,true from Spitter where username=?")
				.authoritiesByUsernameQuery("select username, 'ROLE_USER' from Spitter where username=?")
				.passwordEncoder(new StandardPasswordEncoder());*/
		
		auth.userDetailsService(new SpitterUserService(spitterRespository));
	}

}