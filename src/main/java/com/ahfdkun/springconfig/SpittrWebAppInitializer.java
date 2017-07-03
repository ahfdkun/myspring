package com.ahfdkun.springconfig;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.ahfdkun.springconfig.filter.MyFilter;

/**
 * Java SpringMVC配置
 * @author Administrator
 *
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

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

	@Override
	protected void customizeRegistration(Dynamic registration) { // 支持servlet3.0 multipart
		// registration.setMultipartConfig(new MultipartConfigElement("c:/tmp/spittr/uploads"));
		registration.setMultipartConfig(new MultipartConfigElement("c:/tmp/spittr/uploads", 2097152, 4194304, 0));
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new MyFilter() };
	}
	
}
