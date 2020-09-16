package com.main;

public class Utils {

	public static void wait(int secondsToSleep) {

		try {
			Thread.sleep(secondsToSleep * 1000);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
		}

	}

}
