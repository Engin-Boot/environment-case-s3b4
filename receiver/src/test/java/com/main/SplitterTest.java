package com.main;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class SplitterTest {

	@Test
	public void ifSplitByCommaThenDontThrowException() throws Exception {
		String line = "abc=500,test1/test2";
		String[] splitLine = Splitter.splitByComma(line);
		
		Assert.assertEquals("abc=500", splitLine[0]);
		Assert.assertEquals("test1/test2", splitLine[1]);
	}
	
	@Test(expected = Exception.class)
	public void ifSplitInvalidLineByCommaThenThowException() throws Exception {
		String line = "abc=500test1/test2";
		Splitter.splitByComma(line);		
	}
	
	@Test
	public void ifSplitByEqualsSignThenDontThrowException() throws Exception {
		String[] line = {"abc=500","test1=1000"};
		Map<String, Integer> check = new LinkedHashMap<>();
		
		for(int i=0; i<line.length; i++){
		
		String[] splitLine = line[i].split("\\=");
		check.put(splitLine[0].trim(), Integer.parseInt(splitLine[1].trim()));
		}
		
		Assert.assertEquals("500", check.get("abc"));
		Assert.assertEquals("test1", check.get("test1"));
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
