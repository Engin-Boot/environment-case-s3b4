package com.main;
import java.util.Map;

public class BreachLevel {

	int[] tempWarnLimit = {4 , 37};
	int[] tempErrorLimit = {0 , 40};
	int[] humidityWarnLimit = {-2147483648 , 70};
	int[] humidityErrorLimit = {-2147483648 , 90};
	boolean flag=true;
	
	 boolean isOperatingConditionsOk(Map<String, Integer> environmentConditionAttributes){
		
		environmentConditionAttributes.forEach((attribute, currentValue) -> {
			
			flag &= warnCheck(attribute, currentValue, tempWarnLimit[0], tempWarnLimit[1]);
			flag &= errorCheck(attribute, currentValue, tempErrorLimit[0], tempErrorLimit[1]);
			//flag &= warnCheck(humid, humidityWarnLimit[0], humidityWarnLimit[1]);
			//flag &= errorCheck(humid, humidityErrorLimit[0], humidityErrorLimit[1]);
			
			System.out.println(attribute + " : " + currentValue);
		});
		
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
	 boolean warnCheck(String attribute, int val, int warnLow, int warnHigh)
	 {
		 if(val < warnLow)
	        {
	            System.out.println("There is a WARN level LOW limit breach for "+attribute+" in the " + Thread.currentThread().getStackTrace()[2].getMethodName());
	            return false;
	        }
		 
		 if(val > warnHigh)
	        {
	            System.out.println("There is a WARN level HIGH limit breach for "+attribute+" in the " + Thread.currentThread().getStackTrace()[2].getMethodName());
	            return false;
	        }
		 return true;
	 }
	 
	 boolean errorCheck(String attribute, int val, int errorLow, int errorHigh)
	 {
		 if(val < errorLow)
	        {
	            System.out.println("There is a ERROR level LOW limit breach for "+attribute+" in the " + Thread.currentThread().getStackTrace()[2].getMethodName());
	            return false;
	        }
		 
		 if(val > errorHigh)
	        {
	            System.out.println("There is a ERROR level HIGH limit breach for "+attribute+" in the " + Thread.currentThread().getStackTrace()[2].getMethodName());
	            return false;
	        }
		 return true;
	 }
}
