package com.ahfdkun.springconfig;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.CustomValidatorBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.ahfdkun.controller.IndexController;

@Configuration
@ComponentScan(basePackageClasses = IndexController.class, includeFilters=@Filter(Controller.class)) // 启动组件扫描
@EnableWebMvc // 启用SpringMVC,把WebMvcConfigurationSupport当成配置文件来用，与@ImportResource只能存在一个
// @ImportResource("WEB-INF/spring-servlet.xml")
public class SpringMVCJavaConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		// 配置JSP视图解析器
        /*InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("/WEB-INF/view/");
        resourceViewResolver.setSuffix(".jsp");
        resourceViewResolver.setViewClass(JstlView.class);
        resourceViewResolver.setExposeContextBeansAsAttributes(true); // 设置Spring上下文bean是否在页面显示
        return resourceViewResolver;*/
        
        // 配置Apache Tiles视图解析器
        return new TilesViewResolver();
    }
	
	@Bean
	public MessageSource messageSource() { // 国际化使用
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer() { // 指定Tiles定义的位置
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions("/WEB-INF/layout/tiles.xml");
		tiles.setCheckRefresh(true); // 启动刷新功能
		return tiles;
	}
	
	// 配置静态资源的处理
	// 等同于 <mvc:default-servlet-handler />
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// 验证器
	@Override
	public Validator getValidator() {
		return new CustomValidatorBean();
	}
	
}
	