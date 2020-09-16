package com.main;
import java.io.InputStream;
import java.util.*;

import java.util.Map;

public class BreachLevel {

	int[] tempWarnLimit = {4 , 37};
	int[] tempErrorLimit = {0 , 40};
	int[] humidityWarnLimit = {-1 , 70};
	int[] humidityErrorLimit = {-1 , 90};
	
	 boolean isOperatingConditionsOk(Map<String, Integer> environmentConditionAttributes){
		
		boolean flag=true;
		int temp=environmentConditionAttributes.get("temperature");
		int humid=environmentConditionAttributes.get("humidity");
		
		environmentConditionAttributes.forEach((k, v) -> {
			System.out.println(k + " : " + (v + 10));
		});
		
		flag &= warnAndErrorCheck(temp, tempWarnLimit[0], tempErrorLimit[0], tempWarnLimit[1], tempErrorLimit[1]);
		flag &= warnAndErrorCheck(humid, humidityWarnLimit[0], humidityErrorLimit[0], humidityWarnLimit[1], humidityErrorLimit[1]);
		return flag;
	}
	
/*
	 boolean temperatureBreachCheck(int temp)
	{
		if(warnAndErrorCheck(temp, tempWarnLimit[0], tempErrorLimit[0], tempWarnLimit[1], tempErrorLimit[1]))
		{
			return true;
		}
		return false;
	}
	
	boolean HumidityBreachCheck(int humid)
	{
		if(warnAndErrorCheck(humid, humidityWarnLimit[0], humidityErrorLimit[0], humidityWarnLimit[1], humidityErrorLimit[1]))
		{
			return true;
		}
		return false;
	}
*/	
	boolean warnAndErrorCheck(int val, int warnLow, int errorLow, int warnHigh, int errorHigh)
	{
		if(warnLow != -1){
			if(val < errorLow)
	        {
	            System.out.println("There is a ERROR level LOW limit breach in the " + Thread.currentThread().getStackTrace()[2].getMethodName());
	            return false;
	        }
			
			if(val < warnLow)
	        {
	            System.out.println("There is a WARN level LOW limit breach in the " + Thread.currentThread().getStackTrace()[2].getMethodName());
	            return false;
	        }
		}
		
			if(val > errorHigh)
	        {
	            System.out.println("There is a ERROR level HIGH limit breach in the " + Thread.currentThread().getStackTrace()[2].getMethodName());
	            return false;
	        }
			
			if(val > warnHigh)
	        {
	            System.out.println("There is a WARN level HIGH limit breach in the " + Thread.currentThread().getStackTrace()[2].getMethodName());
	            return false;
	        }
		
		return true;
	}

}
