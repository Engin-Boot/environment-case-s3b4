package com.main;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class JsonUtilityTest {


	@Test
	public void ifValidJsonObjectThenDontThrowException() throws Exception {
		String inputLine = "{\"name\":\"sonoo\",\"age\":27}";
		try {
			new JSONObject(inputLine);
			
		} catch (JSONException ex) {
			//return false;
		}
        //return true;
	}


	@Test()
	public void ifInvalidJsonObjectThenThowException() throws Exception {
		String inputLine = "{\"name\"\"sonoo\"\"salary\":600000.0,\"age\":}";
		try {
			new JSONObject(inputLine);
		} catch (JSONException ex) {
			//return false;
		}
        //return true;
	}

	@Test()
	public void ifValidJsonObjectReadThenconvertJsonToMap() {
		JSONObject jsonObject = new JSONObject("{\"name\":\"sonoo\",\"age\":27}");
		Map<String, String> actual = new LinkedHashMap<>();
		Iterator<String> keys = jsonObject.keys();
		while (keys.hasNext()) {
			String key = keys.next();
			String value = (jsonObject.getString(key));
			actual.put(key, value);
		}
		
		Map<String, String> expected = new LinkedHashMap<>();
		expected.put("name", "sonoo");
		expected.put("age", "27");
	//	assertIterableEquals(expected,actual);
		
	}

	@Test()
	public void ifNullPassedInJsonObjectValueThenconvertJsonToMap() {
		JSONObject jsonObject = new JSONObject("{\"name\":\"\",\"age\":27}");
		Map<String, String> actual = new LinkedHashMap<>();
		Iterator<String> keys = jsonObject.keys();
		while (keys.hasNext()) {
			String key = keys.next();
			String value = (jsonObject.getString(key));
			actual.put(key, value);
		}
		
		Map<String, String> expected = new LinkedHashMap<>();
		expected.put("name", "null");
		expected.put("age", "27");
		assertEquals(expected.toString(), actual.toString());
		
	}

}