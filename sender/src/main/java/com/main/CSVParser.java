package com.main;

import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;

public class CSVParser {

	public void parseCSV(String file) throws IOException {
		  try { 
	 
	        FileReader filereader = new FileReader(file); 
	   
	        CSVReader csvReader = new CSVReader(filereader); 
	        String[] nextRecord; 
	        String[] headers;
	        headers = csvReader.readNext();
	        
	        while ((nextRecord = csvReader.readNext()) != null) { 
	        	
	            for (int i =0; i< headers.length ; i++) { 
	            	
	            	String attributeValue = headers[i]+"="+nextRecord[i]+ " ";
	            	System.out.print(attributeValue);
	            } 
	            System.out.println();
	            Utils.wait(2);
	            
	        } 
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
	
	}
}
