package com.ahfdkun.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
// @Component
public class Audience {

	public static Logger log = Logger.getLogger(Audience.class);
	
	@Pointcut("execution(** com.ahfdkun.service.Performance.perform(..))") // 定义命名的切点
	public void performance() {}
	
	@Before("performance()")
	public void silenceCellPhones() { // 表演前
		log.info("Silencing cell phones");
	}
	
	@Before("performance()")
	public void takeSeats() { // 表演前
		log.info("Taking seats");
	}
	
	@AfterReturning("performance()")
	public void applause() { // 表演成功后
		log.info("CLAP CLAP CLAP");
	}
	
	@AfterThrowing("performance()")
	public void demandRefund() { // 表演失败后
		log.info("Demanding a refund");
	}
	
	@Around("execution(** com.ahfdkun.service.Performance.perform(..))")
	public void watchPerformance(ProceedingJoinPoint jp) {
		try {
			log.info("Silencing cell phones!!");
			log.info("Taking seats!!");
			jp.proceed();
			jp.proceed();
			log.info("CLAP CLAP CLAP!!");
		} catch (Throwable e) {
			log.info("Demanding a refund!!", e);
		}
	}
	
}
