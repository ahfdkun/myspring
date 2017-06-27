package com.ahfdkun.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import com.ahfdkun.service.Encoreable;
import com.ahfdkun.service.impl.DefaultEncoreable;

@Aspect
@Component
public class EncoreableIntroducer {

	// 定义切面，将Encoreable接口引入到Performance bean中
	@DeclareParents(value = "com.ahfdkun.service.Performance+", defaultImpl = DefaultEncoreable.class)
	public Encoreable e;

}
