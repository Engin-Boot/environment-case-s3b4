package com.main;

import java.util.ArrayList;
import java.util.Map;

public class ObjectCreateService {
	
	
public static EnvironmentAttribute[] createObjects(ArrayList<Integer> warnErrorLimitsValueList, Map<String, String> environmentAttributesValues)
{
	EnvironmentAttribute[] objAttribute = new EnvironmentAttribute[environmentAttributesValues.size()];
	int flag1 =0;
	int flag2 =0;
	
    for (String AttributeName : environmentAttributesValues.keySet())  
    {
        String currentValWithUnit = environmentAttributesValues.get(AttributeName);
        int currentVal = getCurrentValueWithoutUnit(currentValWithUnit);
        char unit = getUnit(currentValWithUnit);
        
        objAttribute[flag1++] = new EnvironmentAttribute(AttributeName, currentVal, warnErrorLimitsValueList.get(flag2), 
        		                warnErrorLimitsValueList.get(flag2+1), warnErrorLimitsValueList.get(flag2+2), 
        		                warnErrorLimitsValueList.get(flag2+3), unit);
        flag2 +=4;
    }
	
    return objAttribute;
}

public static char getUnit(String currentValwithUnit)
{
	char unit = currentValwithUnit.charAt(currentValwithUnit.length()-1);
	return unit;
}

public static int getCurrentValueWithoutUnit(String currentValwithUnit)
{
	int currentVal = Integer.parseInt(currentValwithUnit.substring(0, currentValwithUnit.length() - 1));
	return currentVal;
}

}
