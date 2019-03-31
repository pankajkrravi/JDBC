package org.jspiser.ConApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConDemo {
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver clasess loadsed and Registe=red");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection established with DB");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			System.out.println("Costly resource closed");
		}

	}
}
