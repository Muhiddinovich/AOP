package com.freding.aop.oapexample.business;

import java.util.Arrays;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.freding.aop.oapexample.data.DataService1;
import com.freding.aop.oapexample.data.DataService2;

@Service
public class BusinessService2 {
	private DataService2 dataService2;
	
	public BusinessService2(DataService2 dataService2) {
		this.dataService2=dataService2;
	}
	
	public int calculateMin() {
		int[] data = dataService2.retrieveData();
//		throw new RuntimeException("Something went wrong!");
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Arrays.stream(data).min().orElse(0);
	}

}
