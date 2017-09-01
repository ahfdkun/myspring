package com.ahfdkun.springconfig;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.ahfdkun.repository.jpa.SpitterRepository;
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
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SpitterRepository spitterRespository;
	
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

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		addEncodingFilter(http);
		
		/*http.authorizeRequests().regexMatchers("/spitter/\\w{1,}").authenticated()
		.antMatchers(HttpMethod.POST, "/spittles").authenticated()
		.anyRequest().permitAll();*/
		
		/*http.authorizeRequests().antMatchers("/spitter/**").hasAuthority("ROLE_SPITTER")
		.antMatchers(HttpMethod.POST, "/spittles").hasAuthority("ROLE_SPITTER")
		.anyRequest().permitAll();*/
		
		// SpringEL
		http.authorizeRequests()
		.antMatchers("/spitter/**").access("hasRole('ROLE_SPITTER')")
		.regexMatchers("/spittles.*").access("hasRole('ROLE_SPITTER')")
//		.antMatchers(HttpMethod.POST, "/spittles").hasRole("SPITTER")
		.anyRequest().permitAll()
//		.and().requiresChannel().antMatchers("/spitter/register").requiresSecure() // 需要HTTPS，自动重定向到HTTPS
//		.and().requiresChannel().antMatchers("/").requiresInsecure() // 自动重定向到HTTP
		.and()
		.csrf().disable() // 禁用csrf
		.formLogin().loginPage("/login") // 登录
		.and().rememberMe().tokenValiditySeconds(3000).key("spittrKey") // 记住我
		.and().logout().logoutSuccessUrl("/").logoutUrl("/signout") // 退出
		.and().sessionManagement().maximumSessions(-1).maxSessionsPreventsLogin(true).sessionRegistry(sessionRegistry());
//		.and()
//		.httpBasic().realmName("Spittr"); // Http Basic 
	
	}
	
	/*@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager() {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(dataSource);
		return jdbcUserDetailsManager;
	}*/
	
	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}

	// 设置SpringSecurity乱码问题
	private void addEncodingFilter(HttpSecurity http) {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);
		http.addFilterBefore(encodingFilter, CsrfFilter.class);
	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception { // 方法安全需要使用
		return super.authenticationManagerBean();
	}

}