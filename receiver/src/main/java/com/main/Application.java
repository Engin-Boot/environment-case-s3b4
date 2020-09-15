package com.main;
import java.io.*;

public class Application {

	public static void main(String[] args){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		Splitter s=new Splitter();
        
		try{
        	String readInput= br.readLine();
        	while(readInput!=null)
        	{
        		//Splitter s=new Splitter();
        		
        		s.splitByCommaAndEqualsSign(readInput);
        		
        		
        	readInput= br.readLine();
        	//System.out.println("Printing the input read via console: "+ readInput);
        	}
        } catch(IOException e){
        	System.out.println(e);
        }
        
    }
}

