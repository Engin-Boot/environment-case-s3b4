package com.main;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

public class PropertyFileHandler {

	public ArrayList<Integer> getPropValues() throws IOException {
		
		Map<String, Integer> warnErrorLimits = new LinkedHashMap<String, Integer>();
		
	try {
		String propFileName = "WarningErrorLevel.properties";
		Properties prop = new Properties();	
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		
		if (inputStream != null) {
			prop.load(inputStream);
			
			warnErrorLimits = loadFile(prop);
			
		} else {
			throw new FileNotFoundException("property file " + propFileName + " not found in the classpath");
		}	
	}catch (Exception e) {
		System.out.println("Exception: " + e);
	}

	
	ArrayList<Integer> warnErrorLimitsValueList = new ArrayList<Integer>(warnErrorLimits.values());
	return warnErrorLimitsValueList;
}
	
	public Map<String, Integer> loadFile(Properties prop){
		
		Map<String, Integer> warnErrorLimits = new LinkedHashMap<String, Integer>();
		
		Set<Object>keySet=prop.keySet();
		TreeSet<Object>sortedSet=new TreeSet<Object>(keySet);
		Iterator<Object>iterator=sortedSet.iterator();
		while(iterator.hasNext())
		{
			String s= iterator.next().toString();
			warnErrorLimits.put(s,Integer.parseInt(prop.getProperty(s)));
		    
		}
		return warnErrorLimits;
	}
	
}

/*	
System.out.println("<<<--- Map iteration start -->>>");
warnErrorLimits.forEach((k,v) -> System.out.println("Key = "
        + k + ", Value = " + v));
System.out.println("<<<--- Map iteration stop -->>>");
*/

/*
int[] tempWarnLimit = {Integer.parseInt(prop.getProperty("temperature.warnLowLevel")) , Integer.parseInt(prop.getProperty("temperature.warnHighLevel"))};
int[] tempErrorLimit = {Integer.parseInt(prop.getProperty("temperature.errorLowLevel")) , Integer.parseInt(prop.getProperty("temperature.errorHighLevel"))};
int[] humidityWarnLimit = {Integer.parseInt(prop.getProperty("humidity.warnLowLevel")) , Integer.parseInt(prop.getProperty("humidity.warnHighLevel"))};
int[] humidityErrorLimit = {Integer.parseInt(prop.getProperty("humidity.errorLowLevel")) , Integer.parseInt(prop.getProperty("humidity.errorHighLevel"))};

warnErrorLimits.put("tempWarnLimit", tempWarnLimit);
warnErrorLimits.put("tempErrorLimit", tempErrorLimit);
warnErrorLimits.put("humidityWarnLimit", humidityWarnLimit);
warnErrorLimits.put("humidityErrorLimit", humidityErrorLimit);
*/