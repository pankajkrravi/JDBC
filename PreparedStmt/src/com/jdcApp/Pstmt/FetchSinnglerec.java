package com.jdcApp.Pstmt;
import java.sql.*;
public class FetchSinnglerec {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sqry = "select * from jdbcdb.student";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt = con.prepareStatement(sqry);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("sid");
				String name = rs.getString("sname");
				double perc = rs.getDouble(3);
				System.out.println(id + "  " + name + "   " + perc);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
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
