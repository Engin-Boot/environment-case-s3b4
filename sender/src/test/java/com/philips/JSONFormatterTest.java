package com.philips;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class JSONFormatterTest {

	@Test
	void formatShouldReturnNumberOfLinesFormatted() {
		IFormatter formatter = new JSONFormatter();

		IReader parser = new ReadCSV();
		final String FILE_PATH = "C:/anaghesh/Bootcamp_Training/Case_Study_1/environment-case-s3b4/sender/EMS_data.csv";
		List<String[]> data = parser.read(FILE_PATH);
		int actual = formatter.format(data);
		int expected = 6;
		assertEquals(expected, actual);
	}
}
