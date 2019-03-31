package com.jspApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchStmt {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String iqry = "insert into jdbcdb.student values(104,'Shradha',76.23)";
		String uqry = "update jdbcdb.user set name='Guldu' where password='ravi'";
		String dqry = "delete from jdbcdb.student where perc=78.21";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			stmt = con.createStatement();
			// add DML queries into Batch
			stmt.addBatch(iqry);
			stmt.addBatch(dqry);
			stmt.addBatch(uqry);
			int arr[] = stmt.executeBatch();
			for (int i : arr)
				System.out.print(i + " ");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
