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

	

	public static void main(String[] args) {

		IReader parser = new ReadCSV();
		
		List<String[]> data = parser.read(getPath());

		IFormatter jsonFormat = new JSONFormatter();

		jsonFormat.format(data);

	}
	
	public static String getPath() {
		String FILE_PATH=null;
		try {
			FileReader reader = new FileReader("sender.properties");
			Properties property = new Properties();
			property.load(reader);
			 FILE_PATH = property.getProperty("path");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return FILE_PATH;
	}

}
