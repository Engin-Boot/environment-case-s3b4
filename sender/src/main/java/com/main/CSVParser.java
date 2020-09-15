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
	        	
	        	printRecord(headers, nextRecord);
	            System.out.println();
	            Utils.wait(2);
	            
	        } 
	    }

	private void printRecord(String[] headers, String[] nextRecord) {
		
	    for (int i =0; i< headers.length ; i++) { 
        	
        	String attributeValue = headers[i]+"="+nextRecord[i];
        	attributeValue = isLastElement(i, attributeValue, headers);
          		
        	System.out.print(attributeValue);
        } 
		
	}

	private String isLastElement(int i,String attributeValue, String[] headers) {
		
		if(i !=headers.length -1 ) {
    		return attributeValue + ", ";
    	}
		return attributeValue;
	} 
	 
	}

