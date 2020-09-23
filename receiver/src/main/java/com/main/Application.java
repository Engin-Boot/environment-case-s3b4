
/**

  * @author sanjeev.kumar@philips.com

 */

package com.main;

import java.io.*;


import java.util.ArrayList;
import java.util.Map;

import org.json.JSONObject;

public class Application {

	public static void main(String[] args) throws Exception {

		try {
 
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			PropertyFileHandler propertiesFileObj = new PropertyFileHandler();

			BreachLevel breachObj = new BreachLevel();

			ArrayList<Integer> warnErrorLimitsValueList = propertiesFileObj.getPropValues();

			String readInput = br.readLine();

			while (readInput != null) {

				JsonUtility.isJSONValid(readInput);
				
				JSONObject jsonObject = new JSONObject(readInput.trim());

				Map<String, String> environmentAttributesValues = JsonUtility.convertJsonToMap(jsonObject);

				EnvironmentAttribute[] AttributesObj = ObjectCreateService.createObjects(warnErrorLimitsValueList,
						                               environmentAttributesValues);

				breachObj.setNotification(new NotifyWhenBreachBySMS());
				
				breachObj.isOperatingConditionsOk(AttributesObj);

				
				readInput = br.readLine();

			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
