package com.thewalking.aspect;

import java.util.logging.Level;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect  
@Configuration 
//@Component
public class BeforeServiceAspect {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Before(value = "com.thewalking.aspect.CommonJoinPointConfig.businessLayerExecution()")
	public void beforeAdvice(JoinPoint joinPoint) { //dfd  
		log.warn("Before method:" + joinPoint.getSignature());  
		log.warn("get list of products - " );  
	}  
}  