
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
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		PropertyFileHandler propertiesFileObj = new PropertyFileHandler();
		
		BreachLevel breachObj=new BreachLevel();
	try{
			ArrayList<Integer> warnErrorLimitsValueList = propertiesFileObj.getPropValues();
        	
			String readInput= br.readLine();
        	
			while(readInput!=null)
        	{
        	
        	String[] commaSeperatedAttributes = Splitter.splitByComma(readInput);
        	
        	Map<String, Integer> environmentConditionAttributes = Splitter.splitByEqualsSign(commaSeperatedAttributes);
        	
        	EnvironmentAttribute[] objAttribute = ObjectCreateService.createObjects(warnErrorLimitsValueList, environmentConditionAttributes);
        	
        	boolean flag=breachObj.isOperatingConditionsOk(objAttribute);
        	System.out.println("This is random print: "+ flag);
        	readInput= br.readLine();
        	
        	}
        } catch(IOException e){
        	System.out.println(e);
        }
        
    }
}

