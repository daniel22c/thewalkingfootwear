package com.thewalking.aspect;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.thewalking.model.Product;

public class CommonJoinPointConfig {
	public CommonJoinPointConfig() {
		
	}
//	public void dataLayerExecution(){
//	}
	@Pointcut(value ="execution(* com.thewalking.controller.*.*(..))")
	public void businessLayerExecution(){
		
	}
}
