
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
		BreachLevel breachObj=new BreachLevel();
		
        
		try{
        	String readInput= br.readLine();
        	while(readInput!=null)
        	{
        		
        	Map<String, Integer> environmentConditionAttributes = Splitter.splitByCommaAndEqualsSign(readInput);
        	breachObj.isOperatingConditionsOk(environmentConditionAttributes);
        	readInput= br.readLine();
        	
        	}
        } catch(IOException e){
        	System.out.println(e);
        }
        
    }
}

