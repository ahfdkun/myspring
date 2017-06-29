package com.ahfdkun.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.ahfdkun.controller.IndexController;

@Configuration
@ComponentScan(basePackageClasses = IndexController.class, includeFilters=@Filter(Controller.class)) // 启动组件扫描
@EnableWebMvc // 启用SpringMVC,把WebMvcConfigurationSupport当成配置文件来用，与@ImportResource只能存在一个
// @ImportResource("WEB-INF/spring-servlet.xml")
public class SpringMVCJavaConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() { // 配置JSP视图解析器
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("/WEB-INF/view/");
        resourceViewResolver.setSuffix(".jsp");
        resourceViewResolver.setExposeContextBeansAsAttributes(true); // 使得可以在JSP页面中通过${}访问容器中的bean
        return resourceViewResolver;
    }
	
	// 配置静态资源的处理
	// 等同于 <mvc:default-servlet-handler />
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
	