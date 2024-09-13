package com.freding.aop.oapexample.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Method
@Target(ElementType.METHOD)
//Runtime

@Retention(RetentionPolicy.RUNTIME)
public @interface TrackTime {
	
}
