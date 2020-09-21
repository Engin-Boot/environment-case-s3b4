/*

package com.main;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
 
import org.junit.jupiter.api.Test;

public class SplitterTest {

	@Test
	public void ifSplitByCommaThenDontThrowException() throws Exception {
		String line = "abc=500,test1/test2";
		String[] splitLine = JsonUtility.splitByComma(line);
		String expected= "abc=500";
		String actual1= splitLine[0];
		System.out.println("abc");
		assertEquals(expected, actual1);
		//assertEquals("test1/test2", splitLine[1]);
		System.out.println("def");
	}
	
	@Test()
	public void ifSplitInvalidLineByCommaThenThowException() throws Exception {
		String line = "abc=500test1/test2";
		JsonUtility.splitByComma(line);	
		//assertEquals();
	}
	
	@Test
	public void ifSplitByEqualsSignThenDontThrowException() throws Exception {
		String[] line = {"abc=500","test1=1000"};
		Map<String, Integer> check = new LinkedHashMap<>();
		
		for(int i=0; i<line.length; i++){
		
		String[] splitLine = line[i].split("\\=");
		check.put(splitLine[0].trim(), Integer.parseInt(splitLine[1].trim()));
		}
		
		assertEquals("500", check.get("abc"));
		assertEquals("test1", check.get("test1"));
	}
	
	@Test(expected = Exception.class)
	public void ifSplitInvalidLineByEqualsSignThenThowException() throws Exception {
		String[] line = {"abc500","test11000"};
		Map<String, Integer> check = new LinkedHashMap<>();
		
		for(int i=0; i<line.length; i++){
		
		String[] splitLine = line[i].split("\\=");
		check.put(splitLine[0].trim(), Integer.parseInt(splitLine[1].trim()));
		}}

}
*/