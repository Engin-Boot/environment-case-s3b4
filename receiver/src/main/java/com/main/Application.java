
/*

  * @author: sanjeev.kumar@philips.com

 */

package com.main;
import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class Application {

	public static void main(String[] args){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BreachLevel breachObj=new BreachLevel();
		PropertyFileHandler properties = new PropertyFileHandler();
		ObjectCreateService ObjServ = new ObjectCreateService();
		
		try{
			ArrayList<Integer> warnErrorLimitsValueList = properties.getPropValues();
        	
			String readInput= br.readLine();
        	
			while(readInput!=null)
        	{
        	
        	String[] commaSeperatedAttributes = Splitter.splitByComma(readInput);
        	
        	Map<String, Integer> environmentConditionAttributes = Splitter.splitByEqualsSign(commaSeperatedAttributes);
        	
        	EnvironmentAttribute[] objAttribute = ObjServ.createObjects(warnErrorLimitsValueList, environmentConditionAttributes);
        	
        	breachObj.isOperatingConditionsOk(objAttribute);
        	
        	readInput= br.readLine();
        	
        	}
        } catch(IOException e){
        	System.out.println(e);
        }
        
    }
}

