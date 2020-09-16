package com.philips;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import com.opencsv.CSVReader;

public class CSVParser {

	public void readCSV(String file) throws IOException {

		// Try-with-resources - resources are autoclosed
		try (FileReader filereader = new FileReader(file)){
			CSVReader csvReader = new CSVReader(filereader);

			parseCSVLineByLine(csvReader);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public void parseCSVLineByLine(CSVReader csvReader) throws IOException {
		String[] nextRecord;
		String[] headers = csvReader.readNext();
		while ((nextRecord = csvReader.readNext()) != null) {

			Map<String, String> record = RecordHandler.getRecord(headers, nextRecord);
			record = RecordHandler.isRecordValid(record);
			System.out.println(RecordHandler.formatOutput(record));
			Utils.delay(2);
		}
	}

}
