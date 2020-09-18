package com.thewalking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)  
public class TheWalkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheWalkingApplication.class, args);
	}

}
