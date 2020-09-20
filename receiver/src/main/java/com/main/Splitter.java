package com.main;
import java.util.*;

public class Splitter {
	
	public static String[] splitByComma(String input)
	{
		String[] commaSeperatedAttributes = input.split("\\s*,\\s*");
		return commaSeperatedAttributes;
	}
	
	 public static Map<String, Integer> splitByEqualsSign(String[] commaSeperatedAttributes) //String readInput
	{
		Map<String, Integer> environmentConditionAttributes = new LinkedHashMap<>(); //If, new attribute is added, no need to make change in the code.
		
		for(int i=0; i<commaSeperatedAttributes.length; i++){
			
			String[] equalSignSeperatedAttributes = commaSeperatedAttributes[i].split("\\=");
			environmentConditionAttributes.put(equalSignSeperatedAttributes[0].trim(), Integer.parseInt(equalSignSeperatedAttributes[1].trim()));
			
		}
		return environmentConditionAttributes;
		
	}

}
