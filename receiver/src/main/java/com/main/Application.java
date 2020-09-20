
/*

  * @author: sanjeev.kumar@philips.com

 */

package com.main;
import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class Application {

	public static void main(String[] args) throws Exception
	{
		
	try{
		
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		    PropertyFileHandler propertiesFileObj = new PropertyFileHandler();
		
		    BreachLevel breachObj=new BreachLevel();
		    
			ArrayList<Integer> warnErrorLimitsValueList = propertiesFileObj.getPropValues();
        	
			String readInput= br.readLine();
        	
			while(readInput!=null)
        	{
        	
        	String[] commaSeperatedAttributes = Splitter.splitByComma(readInput);
        	
        	Map<String, Integer> environmentConditionAttributes = Splitter.splitByEqualsSign(commaSeperatedAttributes);
        	
        	EnvironmentAttribute[] AttributesObj = ObjectCreateService.createObjects(warnErrorLimitsValueList, environmentConditionAttributes);
        	
        	boolean flag=breachObj.isOperatingConditionsOk(AttributesObj);
        	
        	System.out.println("This is random print: "+ flag);
        	readInput= br.readLine();
        	
        	}
        } catch(Exception e){
        	System.out.println(e);
        }
        
    }
}

