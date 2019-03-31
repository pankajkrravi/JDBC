package com.shishira.aonapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConDemo {
	public static void main(String[] args) {
		final String url = "jdbc:mysql://localhost:3306?user=pankaj&password=root";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Loaded and register success");
			Connection con=DriverManager.getConnection(url);
		System.out.println("Connection sucess");	
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("failed to load and register the driver");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connection failed");
		}
	}
}
