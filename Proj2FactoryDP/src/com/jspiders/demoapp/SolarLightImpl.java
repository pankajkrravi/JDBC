package com.jspiders.demoapp;

public class SolarLightImpl implements ISwitch {

	@Override
	public void switchOn() {
		System.out.println("Solar Light switch on");	
	}

	@Override
	public void switchoOff() {
		System.out.println("Solar Light switch off");	
	}

}
