package com.freding.aop.oapexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {
	@Pointcut("execution(* com.freding.aop.oapexample.*.*.*(..))")
	public void businessAndDataPackageConfig() {
	}

	@Pointcut("execution(* com.freding.aop.oapexample.business.*.*(..))")
	public void businessPackageConfig() {
	}

	@Pointcut("execution(* com.freding.aop.oapexample.data.*.*(..))")
	public void dataPackageConfig() {
	}

	@Pointcut("bean(*Service*)")
	public void allPackageConfigBean() {

	}

	@Pointcut("@annotation(com.freding.aop.oapexample.annotations.TrackTime)")
	public void trackTimeAnnotation() {

	}
}
