package org.btm.DmlApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDemo {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String uqry = "UPDATE jdbcdb.student SET sname='Leela' WHERE sid=1";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded an d registred .");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("connection established..");
			stmt = con.createStatement();
			System.out.println("stmt created ...");
			int res = stmt.executeUpdate(uqry);
			System.out.println(res + " rows effected");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if (con != null) {
						try {
							con.close();
							System.out.println("costly resource closed ");
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

}
