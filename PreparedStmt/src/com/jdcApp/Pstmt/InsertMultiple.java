package com.jdcApp.Pstmt;

import java.sql.*;

public class InsertMultiple {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String iqry = "insert into jdbcdb.student values(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and registred");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection established");
			pstmt = con.prepareStatement(iqry);
			pstmt.setInt(1, 20);
			pstmt.setString(2, "kumar");
			pstmt.setDouble(3, 90.23);
			pstmt.executeUpdate();

			pstmt.setInt(1, 21);
			pstmt.setString(2, "ravi");
			pstmt.setDouble(3, 91.23);
			pstmt.executeUpdate();
			pstmt.setInt(1, 22);
			pstmt.setString(2, "bharti");
			pstmt.setDouble(3, 92.23);
			pstmt.executeUpdate();
			System.out.println("Data inserted");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if (con != null)
						try {
							con.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
				}
		}
	}
}
