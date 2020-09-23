package com.main;

import java.util.*;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtility {

	private JsonUtility() {
		throw new IllegalStateException("Utility class, can not be instantiated");
	}

	public static boolean isJSONValid(String input) {
		try {
			new JSONObject(input);
		} catch (JSONException ex) {
			return false;
		}
		return true;
	}


	public static Map<String, String> convertJsonToMap(JSONObject jsonObject) {
		Map<String, String> environmentConditionAttributes = new LinkedHashMap<>();
		Iterator<String> keys = jsonObject.keys();
		while (keys.hasNext()) {
			String key = keys.next();
			String value = (jsonObject.getString(key));
			environmentConditionAttributes.put(key, value);
		}
		return environmentConditionAttributes;
	}

}
