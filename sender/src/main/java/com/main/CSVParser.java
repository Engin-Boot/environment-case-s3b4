package com.main;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.opencsv.CSVReader;

public class CSVParser {

	public void parseCSVLineByLine(String file) throws IOException {

		CSVReader csvReader = null;
		try {  
			FileReader filereader = new FileReader(file);
			csvReader = new CSVReader(filereader);

			String[] nextRecord;
			String[] headers = csvReader.readNext();

			while ((nextRecord = csvReader.readNext()) != null) {

				printRecord(getRecord(headers, nextRecord));
				Utils.wait(2);
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		finally {
			csvReader.close();
		}
	}

	public Map<String, String> getRecord(String[] headers, String[] nextRecord) {

		Map<String, String> record = new LinkedHashMap<String, String>();
		for (int i = 0; i < headers.length; i++) {

			headers[i] = isHeaderNull(headers[i], i);
			record.put(headers[i], nextRecord[i]);
		}
		return record;

	}

	private String isHeaderNull(String header, int i) {

		if (header.isEmpty()) {
			return "Attribute " + i;
		}
		return header;
	}

	public void printRecord(Map<String, String> record) {

		String strRecord = record.toString();
		System.out.println(strRecord.substring(1, strRecord.length() - 1));

	}

	public boolean isRecordValid(Map<String, String> record) {

		return false;
	}

}
