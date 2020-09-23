package com.philips;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ReadCSVTest {
	@Test
	void successfulReadShouldReturnExpectedHeader() throws IOException {
		final String FILE_PATH = Application.getPath();
		ReadCSV parser = new ReadCSV();
		List<String[]> actual = parser.read(FILE_PATH);
		String[] header = { "temperature", "humidity" };
		assertArrayEquals(header, actual.get(0));

	}

	@Test
	void unsuccessfulReadShouldThrowException() throws IOException {
		final String FILE_PATH = "-s3b4/sender/EMS_data.csv";
		ReadCSV parser = new ReadCSV();

		List<String[]> actual = parser.read(FILE_PATH);

		List<String[]> expected = new ArrayList<String[]>();
		String[] header = { "temperature", "humidity" };
		String[] record1 = { "40c", "50%" };

		expected.add(0, header);
		expected.add(1, record1);

		assertNotEquals(expected, actual);

	}

}
