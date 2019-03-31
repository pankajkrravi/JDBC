package org.jspider.CreateStmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Createstmt {
     public static void main(String[] args) {
    	 Connection con=null;
    	 Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver class is koaded iand registred");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection established with DB");
			stmt=con.createStatement();
			System.out.println("Statement or paltform is created");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
