package com.philips;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.opencsv.CSVReader;

public class CSVParser {

	public void readCSV(String file) throws IOException {

		CSVReader csvReader = null;
		try {
			FileReader filereader = new FileReader(file);
			csvReader = new CSVReader(filereader);
			
			parseCSVLineByLine(csvReader);
		} catch (IOException exception) {
			exception.printStackTrace();
		} finally {
			csvReader.close();
		}
	}

	public void parseCSVLineByLine(CSVReader csvReader) throws IOException {
		String[] nextRecord;
		String[] headers = csvReader.readNext();
		while ((nextRecord = csvReader.readNext()) != null) {

			Map<String, String> record = RecordHandler.getRecord(headers, nextRecord);
			if (RecordHandler.isRecordValid(record))
				RecordHandler.printRecord(record);
			Utils.wait(2);
		}
	}

}
