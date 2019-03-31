package org.btm.DmlApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertMultiRec {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String qry1 = "insert into jdbcdb.student values(15,'leela',25.12)";
		String qry2 = "insert into jdbcdb.student values(50,'laila',89.12)";
		String qry3 = "insert into jdbcdb.student values(35,'leela',85.12)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class regi");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println();
			stmt = con.createStatement();
			System.out.println("PLATFORM CREATED");
			stmt.executeUpdate(qry1);
			stmt.executeUpdate(qry2);
			stmt.executeUpdate(qry3);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if (con != null)

					{
						try {
							con.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}
