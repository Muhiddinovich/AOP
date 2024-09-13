package com.freding.aop.oapexample.aspects;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {
	private Logger logger = LoggerFactory.getLogger(getClass());

//	@Around("execution(* com.freding.aop.oapexample.*.*.*(..))")
	@Around("com.freding.aop.oapexample.aspects.CommonPointcutConfig.trackTimeAnnotation()")
	public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		// Start a timer
		long startTimeMillis = System.currentTimeMillis();

		// Execute the method
		Object returnValue = proceedingJoinPoint.proceed();

		// Stop the timer
		long stopTimeMillis = System.currentTimeMillis();

		long executionduration = stopTimeMillis - startTimeMillis;

		logger.info("Around Aspect - {} Method executed in {} ms", proceedingJoinPoint, executionduration);

		return returnValue;
	}
}
