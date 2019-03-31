package org.jdbcApp.BatchPstmt;

import java.sql.*;

public class BatchWRTPstmt {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		String uqry = "update jdbcdb.student set sname='Smriddhi' where sid=4";
		String dqry = "delete from jdbcdb.user where name='ankit'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt = con.prepareStatement(uqry);
			// Add DML query into Batch//
			pstmt.addBatch();
			int arr1[] = pstmt.executeBatch();
			for (int i : arr1)
				System.out.println(i);
			// Add DML query into Batch
			pstmt1 = con.prepareStatement(dqry);
			pstmt1.addBatch();
			int arr2[] = pstmt1.executeBatch();
			for (int j : arr2)
				System.out.println(j);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
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
