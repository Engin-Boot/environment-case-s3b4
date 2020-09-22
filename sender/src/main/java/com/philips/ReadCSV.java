package com.philips;


import java.io.FileReader;
import java.io.IOException;

import java.util.List;


import com.opencsv.CSVReader;

public class ReadCSV implements IReader {

	@Override
	public List<String[]> read(String file) {
		List<String[]> allData = null;
		// Try-with-resources - resources are autoclosed
		try (CSVReader csvReader = new CSVReader(new FileReader(file))) {

			allData = csvReader.readAll();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return allData;
	}


}