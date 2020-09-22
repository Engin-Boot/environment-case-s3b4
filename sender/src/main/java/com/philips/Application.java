/*
 * @author: anaghesh.m@philips.com
 * 
*/
package com.philips;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import java.util.Properties;

import org.json.JSONObject;

public class Application {

	private static String FILE_PATH = "";

	public static void main(String[] args) {

		try {
			FileReader reader = new FileReader("sender.properties");
			Properties property = new Properties();
			property.load(reader);
			FILE_PATH = property.getProperty("path");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IReader parser = new ReadCSV();

		List<String[]> data = parser.read(FILE_PATH);

		IFormatter jsonFormat = new JSONFormatter();

		jsonFormat.format(data);

	}

}
