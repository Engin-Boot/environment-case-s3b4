package com.main;

import java.util.*;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtility {

	public static boolean isJSONValid(String input) {
		try {
			new JSONObject(input);
		} catch (JSONException ex) {
			return false;
		}
		return true;
	}

	public static Map<String, Integer> convertJsonToMap(JSONObject jsonObject) {
		Map<String, Integer> environmentConditionAttributes = new LinkedHashMap<>();
		Iterator<String> keys = jsonObject.keys();
		while (keys.hasNext()) {
			String key = keys.next();
			int value = Integer.parseInt(jsonObject.getString(key).toString());
			environmentConditionAttributes.put(key, value);
		}
		return environmentConditionAttributes;
	}

}

/*
 * public static String[] splitByComma(String input) { String[]
 * commaSeperatedAttributes = input.split("\\s*,\\s*"); return
 * commaSeperatedAttributes; }
 * 
 * public static Map<String, Integer> splitByEqualsSign(String[]
 * commaSeperatedAttributes) //String readInput { Map<String, Integer>
 * environmentConditionAttributes = new LinkedHashMap<>(); //If, new attribute
 * is added, no need to make change in the code.
 * 
 * for(int i=0; i<commaSeperatedAttributes.length; i++){
 * 
 * String[] equalSignSeperatedAttributes =
 * commaSeperatedAttributes[i].split("\\=");
 * environmentConditionAttributes.put(equalSignSeperatedAttributes[0].trim(),
 * Integer.parseInt(equalSignSeperatedAttributes[1].trim()));
 * 
 * } return environmentConditionAttributes;
 * 
 * }
 */