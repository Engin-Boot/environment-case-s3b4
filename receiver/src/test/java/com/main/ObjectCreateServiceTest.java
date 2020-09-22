package com.main;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ObjectCreateServiceTest {

	@Test
	public void ifUnitPresentThenGetUnit()
	{
		String input= "50C";
		char expected='C';
		char actual = input.charAt(input.length()-1);
		
		assertEquals(Character.toString(expected), Character.toString(actual));
	}
	
	@Test
	public void ifUnitNotPresentThenGetFinalCharOfString()
	{
		String input= "50";
		char expected='0';
		char actual = input.charAt(input.length()-1);
		
		assertEquals(Character.toString(expected), Character.toString(actual));
	}
	
	@Test
	public void ifUnitPresentThenGetValueWithoutUnit()
	{
		String input= "50C";
		int expected=50;
		int actual = Integer.parseInt(input.substring(0, input.length() - 1));
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void ifUnitNotPresentThenGetValueWithoutLastDigit()
	{
		String input= "50";
		int expected=5;
		int actual = Integer.parseInt(input.substring(0, input.length() - 1));
		
		assertEquals(expected, actual);
	}

}
