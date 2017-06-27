package com.ahfdkun.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.ahfdkun.controller.IndexController;

@Configuration
@ComponentScan(basePackageClasses = IndexController.class, includeFilters=@Filter(Controller.class))
@ImportResource("/WEB-INF/spring-servlet.xml")
public class SpringMVCJavaConfig {

	/*@Bean
	public ViewResolver viewResolver() {
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("/WEB-INF/view/");
        resourceViewResolver.setSuffix(".jsp");
        resourceViewResolver.setExposeContextBeansAsAttributes(true); // 使得可以在JSP页面中通过${ }访问容器中的bean
        return resourceViewResolver;
    }*/
}
	