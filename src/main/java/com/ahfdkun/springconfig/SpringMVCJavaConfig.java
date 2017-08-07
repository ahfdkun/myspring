package com.ahfdkun.springconfig;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.CustomValidatorBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.ahfdkun.controller.IndexController;

@Configuration
@ComponentScan(basePackageClasses = IndexController.class, includeFilters=@Filter(Controller.class)) // 启动组件扫描
@EnableWebMvc // 启用SpringMVC,把WebMvcConfigurationSupport当成配置文件来用，与@ImportResource只能存在一个
// @ImportResource("WEB-INF/spring-servlet.xml")
public class SpringMVCJavaConfig extends WebMvcConfigurerAdapter {

	public static final String UPLOAD_CHAR_SET = "UTF-8";
	
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
        
        // Thymeleaf视图解析器
        /*ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;*/
    }
	
	@Bean
	public MultipartResolver multipartResolver() throws IOException { // multipart解析器
		// 依赖于servlet3.0
        return new StandardServletMultipartResolver();
		
		// 使用Jakarta Commons FileUpload
		/*CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setUploadTempDir(new FileSystemResource("c:/tmp/spittr/uploads"));
		commonsMultipartResolver.setDefaultEncoding(UPLOAD_CHAR_SET);
		commonsMultipartResolver.setMaxUploadSize(2097152);
		commonsMultipartResolver.setMaxInMemorySize(0);
        return commonsMultipartResolver;*/
    }
	
	@Bean
	public MessageSource messageSource() { // 国际化使用
		/*ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;*/
		
		// 动态刷新信息源
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setCacheSeconds(10);
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
		// configurer.enable(); // Spring RPC模型，会出错
	}

	// 验证器
	@Override
	public Validator getValidator() {
		return new CustomValidatorBean();
	}
	
	// 设置@ResponseBody乱码
	@Bean
	public RequestMappingHandlerAdapter mappingHandlerAdapter() {
		RequestMappingHandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
		StringHttpMessageConverter httpMessageConverter = new StringHttpMessageConverter();
		httpMessageConverter.setWriteAcceptCharset(false);
		httpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.valueOf("text/html;charset=UTF-8")));
		handlerAdapter.setMessageConverters(Arrays.asList(httpMessageConverter));
		return handlerAdapter;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 静态资源的访问路径配置
		registry.addResourceHandler("/resources/images/**").addResourceLocations("/resources/images/");
	}
	
}
	