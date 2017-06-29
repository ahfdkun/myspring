package com.ahfdkun.springconfig;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Java SpringMVC配置
 * @author Administrator
 *
 */
public class MySpringWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() { // Spring对应的配置
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() { // SpringMVC对应的配置
		return new Class<?>[] { SpringMVCJavaConfig.class };
	}

	@Override
	protected String[] getServletMappings() { // 将DispatcherServelt映射到"/"
		return new String[] { "/" };
	}

}
