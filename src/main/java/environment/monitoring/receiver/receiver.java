package environment.monitoring.receiver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class receiver {
		
	public static void main( String[] args ) {
		
		InputStreamReader r=new InputStreamReader(System.in); 
		
		BufferedReader br=new BufferedReader(r);
		
	    String data = null;
		try {
			data = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    String parameters[] = data.split(",");
	    
	    String values[] = {};
	    
	    List<String> valuesList = Arrays.asList(parameters);
	    
	    Map<String, String> parameterValue = new HashMap<String, String>();
	    
	    for(String s : valuesList ) {
	    	
	    	values = s.split("=");
	    	try {
	    		parameterValue.put(values[0], values[1]);
	    	}
	    	catch(ArrayIndexOutOfBoundsException e){
	    		System.out.println("Incorrect input format");
	    	}
	    	
	    }
	    System.out.println(parameterValue);
	}
}
	
	

