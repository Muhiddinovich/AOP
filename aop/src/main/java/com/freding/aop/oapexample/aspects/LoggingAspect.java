package com.freding.aop.oapexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());

	// execution(*PACKAGE.*.*(..))
	@Before("com.freding.aop.oapexample.aspects.CommonPointcutConfig.allPackageConfigBean()") // @Before annotation is advice
	// execution(* com.freding.aop.oapexample.business.*.*(..)) -> Point Cut
	public void logMethodCallBeforeExecution(JoinPoint joinpoint) { // this is Join Point
		logger.info("Before Aspect - {} is called with arguments- {}", joinpoint, joinpoint.getArgs());
	}

	@After("com.freding.aop.oapexample.aspects.CommonPointcutConfig.businessPackageConfig()")
	public void logMethodCallAfterExecution(JoinPoint joinpoint) {
		logger.info("After Aspect - {} has executed", joinpoint);
	}

	@AfterThrowing(pointcut = "\"com.freding.aop.oapexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()\"", throwing = "exception")
	public void logMethodCallAfterException(JoinPoint joinpoint, Exception exception) {
		logger.info("AfterThrowing Aspect - {} has thrown exception {} ", joinpoint, exception);
	}

	@AfterReturning(pointcut = "\"com.freding.aop.oapexample.aspects.CommonPointcutConfig.dataPackageConfig()\"", returning = "resultValue")
	public void logMethodCallAfterSuccessfulExecution(JoinPoint joinpoint,Object resultValue) {
		logger.info("AfteReturning Aspect - {} has thrown exception {} ", joinpoint, resultValue);
	}
}
