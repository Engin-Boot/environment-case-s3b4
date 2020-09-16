package com.main;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.opencsv.CSVReader;

public class CSVParser {

	public void parseCSV(String file) throws IOException {

		FileReader filereader = new FileReader(file);
		CSVReader csvReader = new CSVReader(filereader);

		String[] nextRecord;
		String[] headers = csvReader.readNext();

		while ((nextRecord = csvReader.readNext()) != null) {

			System.out.println(getRecord(headers, nextRecord));
			Utils.wait(2);

		}
		csvReader.close();
	}

	protected Map<String, String> getRecord(String[] headers, String[] nextRecord) {
		
		Map<String, String> record = new HashMap<String, String>();
		String recordValue = "";
		for (int i = 0; i < headers.length; i++) {
			
			record.put(headers[i], nextRecord[i]);
		
		}
		return record;

	}
	

	private String isLastElement(int i, String attributeValue, String[] headers) {

		if (i != headers.length - 1) {
			return attributeValue + ", ";
		}
		return attributeValue;
	}

}
