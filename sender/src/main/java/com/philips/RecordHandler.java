package com.philips;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Utility class
 * Record refers to a row in CSV.
 * */
public class RecordHandler {

	private RecordHandler() {
		throw new IllegalStateException("Utility class");
	}

	public static Map<String, String> getRecord(String[] headers, String[] nextRecord) {

		Map<String, String> record = new LinkedHashMap<>();
		for (int i = 0; i < headers.length; i++) {

			headers[i] = isHeaderNull(headers[i], i);
			record.put(headers[i], nextRecord[i]);
		}
		return record;

	}

	public static String isHeaderNull(String header, int attributeIndex) {

		if (header.isEmpty()) {
			attributeIndex++;
			return "Attribute " + attributeIndex;
		}
		return header;
	}

	public static String formatOutput(Map<String, String> record) {

		String strRecord = record.toString();
		return strRecord.substring(1, strRecord.length() - 1);

	}

	public static Map<String, String> isRecordValid(Map<String, String> record) {

		Map<String, String> currentRecord = record;

		for (Entry<String, String> entry : currentRecord.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			
			if (!(value.matches("[0-9]+"))) {
				value = null;
				currentRecord.put(key, value);
			}
			// ...
		}
		return currentRecord;
	}

}
