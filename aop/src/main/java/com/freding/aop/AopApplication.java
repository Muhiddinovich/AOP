package com.freding.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.freding.aop.oapexample.business.BusinessService1;
import com.freding.aop.oapexample.business.BusinessService2;

@SpringBootApplication
public class AopApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(getClass());

	private BusinessService1 businessService1;
	private BusinessService2 businessService2;

	public AopApplication(BusinessService1 businessService1, BusinessService2 businessService2) {
		this.businessService1 = businessService1;
		this.businessService2 = businessService2;
	}

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("businnesService1 Value returned is {}", businessService1.calculateMax());
		logger.info("businnesService2 Value returned is {}", businessService2.calculateMin());
	}

}
