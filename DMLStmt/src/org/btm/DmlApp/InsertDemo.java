package org.btm.DmlApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String iquery = "insert into jdbcdb.student values(10,'dinga',23.15)";
		
		
		try {
			// step 1
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class Registred and Loaded..");
			// Step 2 establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("connection established");
			// step 3 create stmt
			stmt = con.createStatement();
			System.out.println("platform created...");
			// step 4 execute sql query
			stmt.executeUpdate(iquery);
			System.out.println("date inserted");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
					System.out.println("stmt closed");
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if (con != null) {
						try {
							con.close();
							System.out.println("connection closed");
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}

				}
			}
		}
	}

}
