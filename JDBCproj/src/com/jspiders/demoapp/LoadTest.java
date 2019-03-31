package com.jspiders.demoapp;

public class LoadTest {
	public static void main(String[] args) {
		try
		{
			Class.forName("com.jspiders.demoapp.Fish");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Class not loaded");
		}
	}
}
