package com.ahfdkun.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ahfdkun.domain.Spitter;
import com.ahfdkun.repository.SpitterRespository;

/**
 * @Description Security配置自定义的用户服务。<br>
 * Fix: 可以直接修改Spitter，实现UserDetailsService,这样loadUserByUsername()就能直接返回Spitter本身。<br>
 *
 * @author zhaoyakun
 *
 * @date 2017年7月9日 下午3:12:56
 */
public class SpitterUserService implements UserDetailsService {

	private final SpitterRespository spitterRespository;

	@Autowired
	public SpitterUserService(SpitterRespository spitterRespository) {
		this.spitterRespository = spitterRespository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Spitter spitter = spitterRespository.findByUsername(username);
		if (spitter != null) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));
			return new User(username, spitter.getPassword(), authorities);
		}
		throw new UsernameNotFoundException("User '" + username + "' not found");
	}

}
