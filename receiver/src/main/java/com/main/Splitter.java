package com.main;
import java.util.*;

public class Splitter {

	BreachLevel bl=new BreachLevel();
	
	void splitByCommaAndEqualsSign(String readInput)
	{
		String[] commaSeperatedAttributes = readInput.split("\\s*,\\s*");
		
		ArrayList<Integer> environmentConditionAtrributes = new ArrayList<Integer>();
		
		for(int i=0; i<commaSeperatedAttributes.length; i++){
			
			String[] equalSignSeperatedAttributes = commaSeperatedAttributes[i].split("\\=");
			environmentConditionAtrributes.add(Integer.parseInt(equalSignSeperatedAttributes[1].trim()));
		}
		
		//BreachLevel bl=new BreachLevel();
		bl.isOperatingConditionsOk(environmentConditionAtrributes.get(0), environmentConditionAtrributes.get(1));
		
	}

}
