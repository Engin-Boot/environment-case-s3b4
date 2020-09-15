/*
 * @author: anaghesh.m@philips.com
 * 
*/
package com.main;

import java.io.IOException;

public class Application {
	
	private static String FILE_PATH = "C:/anaghesh/Bootcamp_Training/Case_Study_1/environment-case-s3b4/sender/EMS_data.csv";
	
	public static void main(String[] args) throws Exception {
		
		CSVParser parser = new CSVParser();
		
		parser.parseCSV(FILE_PATH);
	}

}
