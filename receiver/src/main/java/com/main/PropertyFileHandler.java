package com.main;

import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

public class PropertyFileHandler {

	public ArrayList<Integer> getPropValues() throws IOException {

		Map<String, Integer> warnErrorLimits = new LinkedHashMap<String, Integer>();

		try {
			FileReader reader = new FileReader("WarningErrorLevel.properties");
			Properties property = new Properties();
			property.load(reader);

			warnErrorLimits = loadFile(property);

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}

		ArrayList<Integer> warnErrorLimitsValueList = new ArrayList<Integer>(warnErrorLimits.values());
		return warnErrorLimitsValueList;
	}

	public Map<String, Integer> loadFile(Properties prop) {

		Map<String, Integer> warnErrorLimits = new LinkedHashMap<String, Integer>();

		Set<Object> keySet = prop.keySet();
		TreeSet<Object> sortedSet = new TreeSet<Object>(keySet);
		Iterator<Object> iterator = sortedSet.iterator();
		while (iterator.hasNext()) {
			String s = iterator.next().toString();
			warnErrorLimits.put(s, Integer.parseInt(prop.getProperty(s)));

		}
		return warnErrorLimits;
	}

}

