package com.ahfdkun.springconfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

public class WebProjectConfigInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		initializeSpringConfig(container);
		initializeLog4jConfig(container);
		initializeSpringMVCConfig(container);
	}

	private void initializeSpringConfig(ServletContext container) {
		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(SpringJavaConfig.class);
		// Manage the lifecycle of the root application context
		container.addListener(new ContextLoaderListener(rootContext));

	}

	private void initializeLog4jConfig(ServletContext container) {
		container.setInitParameter("log4jConfigLocation", "classpath:log4j.properties");
		container.addListener(Log4jConfigListener.class);
		PropertyConfigurator.configureAndWatch("log4j.properties", 60000);
	}

	private void initializeSpringMVCConfig(ServletContext container) {
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(SpringMVCJavaConfig.class);
		// Register and map the spring rest servlet
		ServletRegistration.Dynamic dispatcher = container.addServlet("SpringMVC", new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.setAsyncSupported(true);
		dispatcher.addMapping("/");
	}

}
