package com.main;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class JsonUtilityTest {


	@Test
	public void ifValidJsonObjectThenDontThrowException() {
		String inputLine = "{\"name\":\"sonoo\",\"age\":27}";
		boolean expected=true;
		boolean actual=JsonUtility.isJSONValid(inputLine);
		assertEquals(expected+"", actual+"");
	}


	@Test()
	public void ifInvalidJsonObjectThenThowException() {
		String inputLine = "{\"name\"\"sonoo\"\"salary\":600000.0,\"age\":}";
		boolean expected=false;
		boolean actual=JsonUtility.isJSONValid(inputLine);
		assertEquals(expected+"", actual+"");
	}

	@Test()
	public void ifValidJsonObjectReadThenconvertJsonToMap() {
		JSONObject jsonObject = new JSONObject("{\"name\":\"sonoo\",\"age\":27}");
		Map<String, String> actual = new LinkedHashMap<>();
		actual = JsonUtility.convertJsonToMap(jsonObject);
		
		Map<String, String> expected = new LinkedHashMap<>();
		expected.put("name", "sonoo");
		expected.put("age", "27");
		assertEquals(expected.toString(), actual.toString());
		
	}

	@Test()
	public void ifNullPassedInJsonObjectValueThenconvertJsonToMap() {
		JSONObject jsonObject = new JSONObject("{\"name\":\"\",\"age\":27}");
		Map<String, String> actual = new LinkedHashMap<>();
		actual = JsonUtility.convertJsonToMap(jsonObject);
		
		Map<String, String> expected = new LinkedHashMap<>();
		expected.put("name", "null");
		expected.put("age", "27");
		assertEquals(expected.toString(), actual.toString());
		
	}

}