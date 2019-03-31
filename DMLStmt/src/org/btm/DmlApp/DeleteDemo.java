package org.btm.DmlApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDemo {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String dqry = "delete from jdbcdb.student where sid=1";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("step 1 .");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("stet 2 executed");
			stmt = con.createStatement();
			System.out.println("step 3 executed");
			int del = stmt.executeUpdate(dqry);
			System.out.println(del + " rows deleted ");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if (con != null)
						try {
							con.close();
							System.out.println("costly resource is closed");
						} catch (SQLException e) {
							e.printStackTrace();
						}
				}
		}
	}
}
