package com.philips;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Record refers to a row in CSV.
 * */
public class RecordHandler {

	public static Map<String, String> getRecord(String[] headers, String[] nextRecord) {

		Map<String, String> record = new LinkedHashMap<String, String>();
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

	public static void printRecord(Map<String, String> record) {

		String strRecord = record.toString();
		System.out.println(strRecord.substring(1, strRecord.length() - 1));

	}

	public static boolean isRecordValid(Map<String, String> record) {
		
		for (String value : record.values()) {
			if (!(value.matches("[0-9]+")))
					return false;
		}
		return true;
	}

}
