/*
 * @author: anaghesh.m@philips.com
 * 
*/
package com.philips;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import java.util.Properties;

public class Application {
	
	static int delayInSeconds = 2;

	public static void main(String[] args) {

		IReader parser = new ReadCSV();

		List<String[]> data = parser.read(getPath());

		IFormatter jsonFormat = new JSONFormatter();

		jsonFormat.format(data);

	}

	public static String getPath() {
		String FILE_PATH = null;
		try (FileReader reader = new FileReader("senderConfig.properties")) {
			Properties property = new Properties();
			property.load(reader);
			FILE_PATH = property.getProperty("path");
			delayInSeconds = Integer.parseInt(property.getProperty("delayInSeconds"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return FILE_PATH;
	}

}
