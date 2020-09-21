package com.main;

public class BreachLevel {
	
	 boolean isOperatingConditionsOk(EnvironmentAttribute[] objAttribute){ // Map<String, Integer> environmentConditionAttributes
		
		boolean flag=true;
        for(int i=0; i<objAttribute.length; i++){
        	
        flag &= warnCheck(objAttribute[i].getAttributeName(), objAttribute[i].getCurrentValue(), objAttribute[i].getWarnLow(), objAttribute[i].getWarnHigh());
        flag &= errorCheck(objAttribute[i].getAttributeName(), objAttribute[i].getCurrentValue(), objAttribute[i].getErrorLow(), objAttribute[i].getErrorHigh());	
        }
		
		return flag;
		}

	 boolean warnCheck(String attributeName, int val, int warnLow, int warnHigh)
	 {
		 //System.out.println("----->");
		 //System.out.println(attributeName + " : " + val +" warn-low "+warnLow+" warn-high "+warnHigh);
		 
		 if(val < warnLow)
	        {
	            System.out.println("There is a WARN level LOW limit breach for "+attributeName);
	            return false;
	        }
		 
		 if(val > warnHigh)
	        {
	            System.out.println("There is a WARN level HIGH limit breach for "+attributeName);
	            return false;
	        }
		 return true;
	 }
	 
	 boolean errorCheck(String attributeName, int val, int errorLow, int errorHigh)
	 {
		 //System.out.println("----->");
		 //System.out.println(attributeName + " : " + val +" error-low "+errorLow+" error-high "+errorHigh);
		 if(val < errorLow)
	        {
	            System.out.println("There is a ERROR level LOW limit breach for "+attributeName);
	            return false;
	        }
		 
		 if(val > errorHigh)
	        {
	            System.out.println("There is a ERROR level HIGH limit breach for "+attributeName);
	            return false;
	        }
		 return true;
	 }
}

/*
 * 			 flag &= temperatureBreachCheck(environmentConditionAttributes.get("temperature"));
			 flag &= humidityBreachCheck(environmentConditionAttributes.get("humidity"));
 */

/*
 * 	 boolean temperatureBreachCheck(int temp){
	 
	 flag &= errorCheck("temperature", temp, tempErrorLimit[0], tempErrorLimit[1]);
	 if(flag)
	 flag &= warnCheck("temperature", temp, tempWarnLimit[0], tempWarnLimit[1]);
	 return flag;
	 
	 }
	 
	 boolean humidityBreachCheck(int humidity){
	 
	 flag &= errorCheck("humidity", humidity, humidityErrorLimit[0], humidityErrorLimit[1]);
	 if(flag)
	 flag &= warnCheck("humidity", humidity, humidityWarnLimit[0], humidityWarnLimit[1]);
	 return flag;
	 
	 }
		 //boolean flag=true;
		//environmentConditionAttributes.forEach((attribute, currentValue) -> {
        //System.out.println(attribute + " : " + currentValue+" "+flag1);
		//});
 */
//final int[] tempWarnLimit = {4 , 37};
//final int[] tempErrorLimit = {0 , 40};
//final int[] humidityWarnLimit = {-2147483648 , 70};
//final int[] humidityErrorLimit = {-2147483648 , 90};
//flag &= temperatureBreachCheck(environmentConditionAttributes.get(temperature);
/*
flag &= errorCheck("temperature", environmentConditionAttributes.get("temperature"), tempErrorLimit[0], tempErrorLimit[1]);
if(flag)
flag &= warnCheck("temperature", environmentConditionAttributes.get("temperature"), tempWarnLimit[0], tempWarnLimit[1]);

flag &= errorCheck("humidity", environmentConditionAttributes.get("humidity"), humidityErrorLimit[0], humidityErrorLimit[1]);
if(flag)
flag &= warnCheck("humidity", environmentConditionAttributes.get("humidity"), humidityWarnLimit[0], humidityWarnLimit[1]);
*/
