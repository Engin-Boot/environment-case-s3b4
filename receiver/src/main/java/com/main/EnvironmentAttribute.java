package com.main;

public class EnvironmentAttribute {

	private String AttributeName;
	private int currentValue;
	private int warnLow;
	private int warnHigh;
	private int errorLow;
	private int errorHigh;
	private char unit;
	

	public EnvironmentAttribute(String AttributeName, int currentValue, int warnLow, int warnHigh, int errorLow, int errorHigh, char unit) {
	
		this.AttributeName = AttributeName;
		this.currentValue = currentValue;
		this.warnLow = warnLow;
		this.warnHigh = warnHigh;
		this.errorLow = errorLow;
		this.errorHigh = errorHigh;
		this.unit = unit;
	}

	public String getAttributeName() {
		return AttributeName;
	}
	
	public int getCurrentValue() {
		return currentValue;
	}

	public int getWarnLow() {
		return warnLow;
	}

	public int getWarnHigh() {
		return warnHigh;
	}

	public int getErrorLow() {
		return errorLow;
	}

	public int getErrorHigh() {
		return errorHigh;
	}

	public char getUnit() {
		return unit;
	}

	@Override
	public String toString() {
		return "EnvironmentAttribute [AttributeName=" + AttributeName + ", currentValue=" + currentValue + ", warnLow="
				+ warnLow + ", warnHigh=" + warnHigh + ", errorLow=" + errorLow + ", errorHigh=" + errorHigh + ", unit="
				+ unit + "]";
	}
	
	





}
