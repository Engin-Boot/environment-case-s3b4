package com.philips;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class RecordHandlerTest {

	@Test
	void getRecordShouldreturnAttributeValueMap() {
		String[] headers = { "temperature", "humidity" };
		String[] nextRecord = { "10", "20" };

		Map<String, String> expected = new LinkedHashMap<>();
		expected.put("temperature", "10");
		expected.put("humidity", "20");
		Map<String, String> actual = RecordHandler.getRecord(headers, nextRecord);

		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	void getRecordWithNullValues() {
		String[] headers = { "temperature", "humidity" };
		String[] nextRecord = { "10", "" };

		Map<String, String> expected = new LinkedHashMap<>();
		expected.put("temperature", "10");
		expected.put("humidity", "null");
		Map<String, String> actual = RecordHandler.isRecordValid(RecordHandler.getRecord(headers, nextRecord));

		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	void nullHeadershouldreturnAttributeNumber() {
		String[] headers = { "temperature", "" };
		String[] nextRecord = { "10", "20" };

		Map<String, String> expected = new LinkedHashMap<>();
		expected.put("temperature", "10");
		expected.put("Attribute 2", "20");
		Map<String, String> actual = RecordHandler.getRecord(headers, nextRecord);

		assertEquals(expected, actual);
	}

	@Test
	void csvWithNoHeadersShouldReturnAttributeNumber() {
		String[] headers = { "", "" };
		String[] nextRecord = { "10", "20" };

		Map<String, String> expected = new LinkedHashMap<>();
		expected.put("Attribute 1", "10");
		expected.put("Attribute 2", "20");
		Map<String, String> actual = RecordHandler.getRecord(headers, nextRecord);

		assertEquals(expected, actual);
	}

	@Test
	void negativeValuesShouldBeAccepted() {
		String[] headers = { "temperature", "humidity" };
		String[] nextRecord = { "-10", "20" };

		Map<String, String> expected = new LinkedHashMap<>();
		expected.put("temperature", "-10");
		expected.put("humidity", "20");
		Map<String, String> actual = RecordHandler.getRecord(headers, nextRecord);

		assertEquals(expected, actual);
	}

	@Test
	void attributeAndValueNullShouldReturnAttributeNoAndNullValues() {
		String[] headers = { "", "" };
		String[] nextRecord = { "", "" };

		Map<String, String> expected = new LinkedHashMap<>();
		expected.put("Attribute 1", "null");
		expected.put("Attribute 2", "null");
		Map<String, String> actual = RecordHandler.isRecordValid(RecordHandler.getRecord(headers, nextRecord));

		assertEquals(expected.toString(), actual.toString());
	}

}
