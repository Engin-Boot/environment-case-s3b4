
/*

  * @author: sanjeev.kumar@philips.com

  *

 */
package com.main;
import java.io.*;
import java.util.Map;

public class Application {

	public static void main(String[] args){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BreachLevel bl=new BreachLevel();
		//Splitter s=new Splitter();
        
		try{
        	String readInput= br.readLine();
        	while(readInput!=null)
        	{
        		//Splitter s=new Splitter();
        		
        		Map<String, Integer> environmentConditionAttributes = Splitter.splitByCommaAndEqualsSign(readInput);
        		bl.isOperatingConditionsOk(environmentConditionAttributes);
        		
        	readInput= br.readLine();
        	//System.out.println("Printing the input read via console: "+ readInput);
        	}
        } catch(IOException e){
        	System.out.println(e);
        }
        
    }
}

