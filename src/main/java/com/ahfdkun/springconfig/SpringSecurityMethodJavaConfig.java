package com.ahfdkun.springconfig;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.ahfdkun.domain.Spittle;

/**
 * @Description 启用基于注解的方法安全性
 *
 * @author zhaoyakun
 *
 * @date 2017年7月9日 上午12:30:10
 */
@Configuration
// 启用基于注解的方法安全性
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SpringSecurityMethodJavaConfig extends GlobalMethodSecurityConfiguration {

	public static Logger log = Logger.getLogger(SpringSecurityMethodJavaConfig.class);

	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
		DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
		expressionHandler.setPermissionEvaluator(new SpittlePermissionEvator());
		return expressionHandler;
	}

	static class SpittlePermissionEvator implements PermissionEvaluator {

		private static final GrantedAuthority ADMIN_AUTHORITY = new SimpleGrantedAuthority("ROLE_ADMIN");

		@Override
		public boolean hasPermission(Authentication authentication, Object target, Object permission) {
			if (target instanceof Spittle) {
				Spittle spittle = (Spittle) target;
				return isAdmin(authentication) || spittle.getMessage().equals("ahfdkun");
			}
			throw new UnsupportedOperationException("不允许操作");
		}

		@Override
		public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
				Object permission) {
			try {
				Class<?> clazz = Class.forName(targetType);
				log.info(clazz);
				return false;
			} catch (Exception e) {
				throw new UnsupportedOperationException("不允许操作");
			}
		}

		private boolean isAdmin(Authentication authentication) {
			return authentication.getAuthorities().contains(ADMIN_AUTHORITY);
		}

	}

}