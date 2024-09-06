package com.freding.aop.oapexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//Configuration
//AOP
@Configuration
@Aspect
public class LoggingAspect {


	private Logger logger = LoggerFactory.getLogger(getClass());

	// Pointcut - When?
	
	// execution(*PACKAGE.*.*(..))
	@Before("execution(* com.freding.aop.oapexample.business.*.*(..))")
	public void logMethodCall(JoinPoint joinpoint) {
		// Logic - What?
		logger.info("Before Aspect - Method is called - {}", joinpoint);
	}
}
