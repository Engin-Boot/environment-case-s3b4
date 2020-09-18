package com.main;
import java.util.Map;

public class BreachLevel {

	final int[] tempWarnLimit = {4 , 37};
	final int[] tempErrorLimit = {0 , 40};
	final int[] humidityWarnLimit = {-2147483648 , 70};
	final int[] humidityErrorLimit = {-2147483648 , 90};
	//flag &= temperatureBreachCheck(environmentConditionAttributes.get(temperature);
	boolean test= true;
	
	 boolean isOperatingConditionsOk(Map<String, Integer> environmentConditionAttributes){
		
		 boolean flag=true;
		//environmentConditionAttributes.forEach((attribute, currentValue) -> {
			
			if(errorCheck("temperature", environmentConditionAttributes.get("temperature"), tempErrorLimit[0], tempErrorLimit[1]))
			flag &= warnCheck("temperature", environmentConditionAttributes.get("temperature"), tempWarnLimit[0], tempWarnLimit[1]);
			
			if(errorCheck("humidity", environmentConditionAttributes.get("humidity"), humidityErrorLimit[0], humidityErrorLimit[1]))
			flag &= warnCheck("humidity", environmentConditionAttributes.get("humidity"), humidityWarnLimit[0], humidityWarnLimit[1]);
			
			
		//flag &= warnCheck(attribute, currentValue, humidityWarnLimit[0], humidityWarnLimit[1]);
		//flag &= errorCheck(attribute, currentValue, humidityErrorLimit[0], humidityErrorLimit[1]);
		//System.out.println(attribute + " : " + currentValue+" "+flag1);
		//});
		
		return (flag);
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
		 //System.out.println(attribute + " : " + val +" warn-low "+warnLow+" warn-high "+warnHigh);
		 
		 if(val < warnLow)
	        {
	            System.out.println("There is a WARN level LOW limit breach for "+attribute);
	            return false;
	        }
		 
		 if(val > warnHigh)
	        {
	            System.out.println("There is a WARN level HIGH limit breach for "+attribute);
	            return false;
	        }
		 return true;
	 }
	 
	 boolean errorCheck(String attribute, int val, int errorLow, int errorHigh)
	 {
		 //System.out.println(attribute + " : " + val +" error-low "+errorLow+" error-high "+errorHigh);
		 if(val < errorLow)
	        {
	            System.out.println("There is a ERROR level LOW limit breach for "+attribute);
	            return false;
	        }
		 
		 if(val > errorHigh)
	        {
	            System.out.println("There is a ERROR level HIGH limit breach for "+attribute);
	            return false;
	        }
		 return true;
	 }
}
