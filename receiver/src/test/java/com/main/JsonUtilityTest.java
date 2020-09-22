package com.main;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class JsonUtilityTest {


	@Test
	public void ifValidJsonObjectThenDontThrowException() {
		String inputLine = "{\"name\":\"sonoo\",\"age\":27}";
		boolean expected=true;
		boolean actual=JsonUtility.isJSONValid(inputLine);
		assertEquals(expected, actual);
	}


	@Test()
	public void ifInvalidJsonObjectThenThowException() {
		String inputLine = "{\"name\"\"sonoo\"\"salary\":600000.0,\"age\":}";
		boolean expected=false;
		boolean actual=JsonUtility.isJSONValid(inputLine);
		assertEquals(expected, actual);
	}

	@Test()
	public void ifValidJsonObjectReadThenconvertJsonToMap() {
		JSONObject jsonObject = new JSONObject("{\"name\":\"sonoo\",\"age\":27}");
		//final Map<String, String> actual1 = new LinkedHashMap<>();
		final Map<String, String> actual1 = JsonUtility.convertJsonToMap(jsonObject);
		
		String actual = actual1.keySet().stream()
			      .map(key -> key + "=" + actual1.get(key))
			      .collect(Collectors.joining(", ", "{", "}"));
		
		Map<String, String> expected1 = new LinkedHashMap<>();
		expected1.put("name", "sonoo");
		expected1.put("age", "27");
		
		String expected = expected1.keySet().stream()
			      .map(key -> key + "=" + expected1.get(key))
			      .collect(Collectors.joining(", ", "{", "}"));
		
		
		assertEquals(expected, actual);
		
	}

	@Test()
	public void ifNullPassedInJsonObjectValueThenconvertJsonToMap() {
		JSONObject jsonObject = new JSONObject("{\"name\":\"\",\"age\":27}");
		final Map<String, String> actual1 = JsonUtility.convertJsonToMap(jsonObject);
		
		String actual = actual1.keySet().stream()
			      .map(key -> key + "=" + actual1.get(key))
			      .collect(Collectors.joining(", ", "{", "}"));
		
		Map<String, String> expected1 = new LinkedHashMap<>();
		expected1.put("name", "null");
		expected1.put("age", "27");
		
		String expected = expected1.keySet().stream()
			      .map(key -> key + "=" + expected1.get(key))
			      .collect(Collectors.joining(", ", "{", "}"));
		
		assertEquals(expected.toString(), actual.toString());
		
	}

}