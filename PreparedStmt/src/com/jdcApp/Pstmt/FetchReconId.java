package com.jdcApp.Pstmt;

import java.sql.*;
import java.util.Scanner;

public class FetchReconId {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String fqry = "select * from jdbcdb.student where sid=?";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id????");
		int sid = scanner.nextInt();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and registred");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection established");
			pstmt = con.prepareStatement(fqry);
			// set the value for placeholder
			pstmt.setInt(1, sid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString(2);
				double perc = rs.getDouble(3);
				System.out.println(name + "  " + perc);
			} else {
				System.err.println("No data found....");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
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
