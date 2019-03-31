package com.jdcApp.Pstmt;

import java.sql.*;
import java.util.Scanner;

public class FetchDataOnName {
	public static void main(String[] args) {
		PreparedStatement pstmt = null;
		Connection con = null;
		String sqry = "select * from jdbcdb.student where sname=?";
		ResultSet rs = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter name????");
		String sname = s.next();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt = con.prepareStatement(sqry);
			pstmt.setString(1, sname);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				double perc = rs.getDouble(3);
				System.out.println(id + "   " + perc);
			}
			else {
				System.err.println("Data not found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}if(pstmt!=null)
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}if(con!=null)
						try {
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		}
	}
}
