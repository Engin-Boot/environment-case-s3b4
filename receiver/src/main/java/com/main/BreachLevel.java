package com.main;

public class BreachLevel {

	NotifyWhenBreach notify;

	void setNotification(NotifyWhenBreach notifiedByMain) {
		notify = notifiedByMain;
	}

	void isOperatingConditionsOk(EnvironmentAttribute[] objAttribute) {

		for (int i = 0; i < objAttribute.length; i++) {

			warnCheckAndSendAlert(objAttribute[i].getAttributeName(), objAttribute[i].getCurrentValue(),
					objAttribute[i].getWarnLow(), objAttribute[i].getWarnHigh());
			errorCheckAndSendAlert(objAttribute[i].getAttributeName(), objAttribute[i].getCurrentValue(),
					objAttribute[i].getErrorLow(), objAttribute[i].getErrorHigh());
		}

	}

	boolean warnCheckAndSendAlert(String attributeName, int val, int warnLow, int warnHigh) {

		if (val < warnLow) {
			String AlertMsg = "WARNING : There is a WARN level LOW limit breach for " + attributeName + " :" + val;
			notify.sendAlert(AlertMsg);
			return false;
		}

		if (val > warnHigh) {
			String AlertMsg = "WARNING : here is a WARN level HIGH limit breach for " + attributeName + " :" + val;
			notify.sendAlert(AlertMsg);
			return false;
		}
		return true;
	}

	boolean errorCheckAndSendAlert(String attributeName, int val, int errorLow, int errorHigh) {
		if (val < errorLow) {
			String AlertMsg = "ERROR : There is a ERROR level LOW limit breach for " + attributeName + " :" + val;
			notify.sendAlert(AlertMsg);
			return false;
		}

		if (val > errorHigh) {
			String AlertMsg = "ERROR : There is a ERROR level HIGH limit breach for " + attributeName + " :" + val;
			notify.sendAlert(AlertMsg);
			return false;
		}
		return true;
	}
}
