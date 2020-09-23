package com.thewalking.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AroundServiceAspect {
private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Around("com.thewalking.aspect.CommonJoinPointConfig.businessLayerExecution()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		Object ret = joinPoint.proceed();

		long timeTaken = System.currentTimeMillis() - startTime;
		logger.warn("Around:Time Taken is {}", timeTaken);
		return ret;
	}
}
