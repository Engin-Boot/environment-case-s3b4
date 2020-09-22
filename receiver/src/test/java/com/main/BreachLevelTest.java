package com.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
public class BreachLevelTest {

	@Test
	public void ifValueBeyondWarningLimitsThenReturnFalse()
	{
		int inputVal= 50;
		int lowLimit= 4;
		int highLimit= 37;
		String name="temp";
		BreachLevel obj= new BreachLevel();
		boolean actual=obj.warnCheckAndSendAlert(name,inputVal,lowLimit,highLimit);
		boolean expected=false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void ifValueWithinWarningErrorLimitsThenDontSendMessage()
	{
		int inputVal= 35;
		int lowLimit= 4;
		int highLimit= 37;
		String name="temp";
		BreachLevel obj= new BreachLevel();
		boolean actual=true;
		actual=obj.warnCheckAndSendAlert(name,inputVal,lowLimit,highLimit);
		
		boolean expected=true;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void ifValueBeyondErrorLimitsThenReturnFalse()
	{
		int inputVal= 50;
		int lowLimit= 0;
		int highLimit= 40;
		String name="temp";
		BreachLevel obj= new BreachLevel();
		boolean actual=obj.errorCheckAndSendAlert(name,inputVal,lowLimit,highLimit);
		boolean expected=false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void ifValueWithinerrorErrorLimitsThenDontSendMessage()
	{
		int inputVal= 35;
		int lowLimit= 0;
		int highLimit= 40;
		String name="temp";
		BreachLevel obj= new BreachLevel();
		boolean actual=true;
		actual=obj.errorCheckAndSendAlert(name,inputVal,lowLimit,highLimit);
		
		boolean expected=true;
		
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