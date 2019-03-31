package com.jspiders.demoapp;

public class LedLightImpl implements ISwitch{
	@Override
	public void switchOn() {
		System.out.println("LED Light switch on");		
	}
	@Override
	public void switchoOff() {
		System.out.println("LED Light swirch off");		
	}

}
