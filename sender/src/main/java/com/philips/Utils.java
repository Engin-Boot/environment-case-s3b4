package com.philips;

public class Utils {

	private Utils() {
		throw new IllegalStateException("Utility class, can not be instantiated ");
	}

	public static void delay(long secondsToSleep) {

		try {
			Thread.sleep(secondsToSleep * 1000);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
		}

	}

}
