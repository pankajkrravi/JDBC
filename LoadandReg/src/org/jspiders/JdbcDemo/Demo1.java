package org.jspiders.JdbcDemo;

public class Demo1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and register");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
