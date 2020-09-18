package com.main;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyFileReader {

	public Map<String, int[]> getPropValues() throws IOException {
		
		Map<String, int[]> warnErrorLimits = new LinkedHashMap<String, int[]>();
		
	try {
		String propFileName = "WarningErrorLevel.properties";
		Properties prop = new Properties();	
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		
		
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file " + propFileName + " not found in the classpath");
		}
		
		int[] tempWarnLimit = {Integer.parseInt(prop.getProperty("temperature.warnLowLevel")) , Integer.parseInt(prop.getProperty("temperature.warnHighLevel"))};
		int[] tempErrorLimit = {Integer.parseInt(prop.getProperty("temperature.errorLowLevel")) , Integer.parseInt(prop.getProperty("temperature.errorHighLevel"))};
		int[] humidityWarnLimit = {Integer.parseInt(prop.getProperty("humidity.warnLowLevel")) , Integer.parseInt(prop.getProperty("humidity.warnHighLevel"))};
		int[] humidityErrorLimit = {Integer.parseInt(prop.getProperty("humidity.errorLowLevel")) , Integer.parseInt(prop.getProperty("humidity.errorHighLevel"))};
		
		warnErrorLimits.put("tempWarnLimit", tempWarnLimit);
		warnErrorLimits.put("tempErrorLimit", tempErrorLimit);
		warnErrorLimits.put("humidityWarnLimit", humidityWarnLimit);
		warnErrorLimits.put("humidityErrorLimit", humidityErrorLimit);
		
	}catch (Exception e) {
		System.out.println("Exception: " + e);
	}
	
	return warnErrorLimits;	
}
}