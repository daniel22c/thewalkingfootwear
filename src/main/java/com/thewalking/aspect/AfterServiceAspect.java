package com.thewalking.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect @Configuration
public class AfterServiceAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@AfterReturning(value = "com.thewalking.aspect.CommonJoinPointConfig.businessLayerExecution()", 
			returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.warn("{} and returned with value {}", joinPoint.toString(),  result);
	}
	@After(value = "com.thewalking.aspect.CommonJoinPointConfig.businessLayerExecution()")
	public void after(JoinPoint joinPoint) {
		logger.warn("after execution ");
	}
}
