package com.main;
import java.util.*;

public class Splitter {

	//static BreachLevel bl=new BreachLevel();
	
	 public static Map<String, Integer> splitByCommaAndEqualsSign(String readInput)
	{
		String[] commaSeperatedAttributes = readInput.split("\\s*,\\s*");
		
		//ArrayList<Integer> environmentConditionAtrributes = new ArrayList<Integer>();
		
		Map<String, Integer> environmentConditionAttributes = new HashMap<>();
		
		for(int i=0; i<commaSeperatedAttributes.length; i++){
			
			String[] equalSignSeperatedAttributes = commaSeperatedAttributes[i].split("\\=");
			environmentConditionAttributes.put(equalSignSeperatedAttributes[0].trim(), Integer.parseInt(equalSignSeperatedAttributes[1].trim()));
			//environmentConditionAtrributes.add(Integer.parseInt(equalSignSeperatedAttributes[1].trim()));
			
		}
		
		return environmentConditionAttributes;
		//BreachLevel bl=new BreachLevel();
		//bl.isOperatingConditionsOk(environmentConditionAttributes.get("temperature"), environmentConditionAttributes.get("humidity"));// change to main
		
	}

}
