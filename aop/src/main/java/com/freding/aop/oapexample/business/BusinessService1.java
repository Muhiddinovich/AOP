package com.freding.aop.oapexample.business;

import java.util.Arrays;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.freding.aop.oapexample.annotations.TrackTime;
import com.freding.aop.oapexample.data.DataService1;

@Service
public class BusinessService1 {
	private DataService1 dataService1;
	
	public BusinessService1(DataService1 dataService1) {
		this.dataService1=dataService1;
	}
	
	@TrackTime
	public int calculateMax() {
		int[] data = dataService1.retrieveData();
//		throw new RuntimeException("Something went wrong!");
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Arrays.stream(data).max().orElse(0);
	}

}
