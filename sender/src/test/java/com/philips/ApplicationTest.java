package com.philips;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ApplicationTest {

	@Test
	void getPathShouldReturnPathFromProperties() {

		String actual = Application.getPath();
		String expected = "EMS_data.csv";
		assertEquals(actual, expected);
	}

}
