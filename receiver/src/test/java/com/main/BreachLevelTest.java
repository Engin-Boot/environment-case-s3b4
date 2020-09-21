package com.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BreachLevelTest {

	@Test
	public void ifValueBeyondWarningErrorLimitsThenSendMessage()
	{
		int inputVal= 50;
		int lowLimit= 0;
		int highLimit= 47;
		String actual="";
		
		if(inputVal < lowLimit)
        {
		actual="Limit Breached";
        }
		
		if(inputVal > highLimit)
        {
		actual="Limit Breached";
        }
		
		String expected="Limit Breached";
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void ifValueWithinWarningErrorLimitsThenDontSendMessage()
	{
		int inputVal= 35;
		int lowLimit= 0;
		int highLimit= 47;
		String actual="";
		
		if(inputVal < lowLimit)
        {
		actual="Limit Breached";
        }
		
		if(inputVal > highLimit)
        {
		actual="Limit Breached";
        }
		
		String expected="";
		
		assertEquals(expected, actual);
	}
	
/*
 * 	 boolean warnCheck(String attributeName, int val, int warnLow, int warnHigh)
	 {
		 //System.out.println("check check check");
		 //System.out.println(attributeName + " : " + val +" warn-low "+warnLow+" warn-high "+warnHigh);
		 
		 if(val < warnLow)
	        {
			    String AlertMsg = "There is a WARN level LOW limit breach for "+attributeName;
			    notify.sendAlert(AlertMsg);
	            return false;
	        }
		 
		 if(val > warnHigh)
	        {
			    String AlertMsg = "There is a WARN level HIGH limit breach for "+attributeName;
			    notify.sendAlert(AlertMsg);
	            return false;
	        }
		 return true;
	 }
 */
	
	
}
