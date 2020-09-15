package com.main;

import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;

public class CSVParser {

	public void parseCSV(String file) throws IOException {
	 
	        FileReader filereader = new FileReader(file); 
	        CSVReader csvReader = new CSVReader(filereader); 
	        
	        String[] nextRecord; 
	        String[] headers = csvReader.readNext();
	        
	        while ((nextRecord = csvReader.readNext()) != null) { 
	        	
	            for (int i =0; i< headers.length ; i++) { 
	            	
	            	String attributeValue = headers[i]+"="+nextRecord[i];
	            	if(i !=headers.length -1 ) {
	            		attributeValue = attributeValue + ", ";
	            	}
	              		
	            	System.out.print(attributeValue);
	            } 
	            System.out.println();
	            Utils.wait(2);
	            
	        } 
	    } 
	 
	}

