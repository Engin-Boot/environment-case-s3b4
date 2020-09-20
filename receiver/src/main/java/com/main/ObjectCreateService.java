package com.main;

import java.util.ArrayList;
import java.util.Map;

public class ObjectCreateService {
	
	
public EnvironmentAttribute[] createObjects(ArrayList<Integer> warnErrorLimitsValueList, Map<String, Integer> environmentConditionAttributes)
{
	EnvironmentAttribute[] objAttribute = new EnvironmentAttribute[environmentConditionAttributes.size()];
	int flag1 =0;
	int flag2 =0;
	
    for (String AttributeName : environmentConditionAttributes.keySet())  
    {
        int currentVal = environmentConditionAttributes.get(AttributeName);
        
        objAttribute[flag1++] = new EnvironmentAttribute(AttributeName, currentVal, warnErrorLimitsValueList.get(flag2), 
        		                warnErrorLimitsValueList.get(flag2+1), warnErrorLimitsValueList.get(flag2+2), warnErrorLimitsValueList.get(flag2+3));
        flag2 +=4;
    }
	
    return objAttribute;
	//EnvironmentAttribute[] objAttribute = new EnvironmentAttribute[5];
}

}
