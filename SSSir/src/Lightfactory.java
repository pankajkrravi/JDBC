package com.jspiders.demoapp;

public class Lightfactory {
	public static ISwitch getLight(String typeOflight) {
		if (typeOflight.equals("led")) {
			return new LedLightImpl();
		} else if (typeOflight.contentEquals("solar")) {
			return new SolarLightImpl();
		} else

			return new MercuryLightImpl();
	}
}
