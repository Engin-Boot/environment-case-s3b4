package com.main;
import java.util.*;

public class Splitter {
	
	 public static Map<String, Integer> splitByCommaAndEqualsSign(String readInput)
	{
		String[] commaSeperatedAttributes = readInput.split("\\s*,\\s*");
		
		Map<String, Integer> environmentConditionAttributes = new HashMap<>(); //If, new attribute is added, no need to make change in the code.
		
		for(int i=0; i<commaSeperatedAttributes.length; i++){
			
			String[] equalSignSeperatedAttributes = commaSeperatedAttributes[i].split("\\=");
			environmentConditionAttributes.put(equalSignSeperatedAttributes[0].trim(), Integer.parseInt(equalSignSeperatedAttributes[1].trim()));
			
		}
		return environmentConditionAttributes;
		
	}

}
