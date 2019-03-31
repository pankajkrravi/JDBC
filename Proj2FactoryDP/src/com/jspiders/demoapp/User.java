package com.jspiders.demoapp;

import java.util.Scanner;

public class User {
   public void read()
   {
	   Scanner s=new Scanner(System.in);
	   System.out.println("Enter light of your choice");
		String typeoflight=s.next();
		ISwitch sw=Lightfactory.getLight(typeoflight);
		sw.switchOn();
		sw.switchoOff();
   }
}
