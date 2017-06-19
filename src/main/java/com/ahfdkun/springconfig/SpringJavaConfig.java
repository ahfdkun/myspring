package com.ahfdkun.springconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import com.ahfdkun.service.MyService;

@Configuration
@ComponentScan(basePackageClasses = MyService.class, excludeFilters = @Filter(Controller.class))
public class SpringJavaConfig {

}
