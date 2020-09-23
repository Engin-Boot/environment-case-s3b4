package com.philips;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class JSONFormatter implements IFormatter {

	@Override
	public int format(List<String[]> data) {
		String[] header = data.get(0);

		for (int i = 1; i < data.size(); i++) {

			Map<String, String> record = RecordHandler.getRecord(header, data.get(i));
			// record = RecordHandler.isRecordValid(record);

			System.out.println(new JSONObject(record));
			Utils.delay(Application.delayInSeconds);
		}
		return data.size();

	}

}
