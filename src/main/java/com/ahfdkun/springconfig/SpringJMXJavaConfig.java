package com.ahfdkun.springconfig;

import java.util.HashMap;
import java.util.Map;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.assembler.InterfaceBasedMBeanInfoAssembler;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.jmx.support.MBeanServerFactoryBean;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;

import com.ahfdkun.controller.SpittleController;
import com.ahfdkun.service.SpittleControllerManagedOperations;

/**
 * @Description 将SpittleController导出MBean 
 *
 * @author zhaoyakun
 *
 * @date 2017年7月27日 下午9:05:40
 */
@Configuration
public class SpringJMXJavaConfig {

	@Bean
	public MBeanExporter mbeanExporter(SpittleController spittleController, MBeanServer mBeanServer) {
		MBeanExporter mBeanExporter = new MBeanExporter();
		Map<String, Object> beans = new HashMap<>();
		beans.put("bean:name=spittleController", spittleController);
		mBeanExporter.setBeans(beans);
		mBeanExporter.setServer(mBeanServer);
		mBeanExporter.setAssembler(assembler());
		return mBeanExporter;
	}
	
	@Bean
	public MBeanServerFactoryBean mBeanServer() { // 设置MBean Server
		return new MBeanServerFactoryBean();
	}
	
	@Bean
	public InterfaceBasedMBeanInfoAssembler assembler() { // MBean通过名称暴露方法
		InterfaceBasedMBeanInfoAssembler assembler = new InterfaceBasedMBeanInfoAssembler();
		assembler.setManagedInterfaces(new Class<?>[] { SpittleControllerManagedOperations.class });
		return assembler;
	}
	
	@Bean
	public RmiRegistryFactoryBean rmiRegistryFB() {
		RmiRegistryFactoryBean rmiRegistryFB = new RmiRegistryFactoryBean();
		rmiRegistryFB.setPort(1099);
		return rmiRegistryFB;
	}
	
	
	@Bean
	public ConnectorServerFactoryBean serverConnector() throws MalformedObjectNameException {
		ConnectorServerFactoryBean csf = new ConnectorServerFactoryBean();
		csf.setServiceUrl("service:jmx:rmi://localhost/jndi/rmi://localhost:1099/spittle");
		return csf;
	}
	
}
	