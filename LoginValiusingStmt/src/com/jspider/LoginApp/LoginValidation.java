package com.jspider.LoginApp;
import java.sql.*;
import java.util.Scanner;
public class LoginValidation {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String qry="select username from jdbcdb.user where name=? and password=?";
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter name ????");
		String name=scanner.next();
		System.out.println("Enter password???");
		String password=scanner.next();
		scanner.close();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				String username=rs.getString(1);
				System.out.println("welcome "+username);
			}
			else {
				System.err.println("invalid user/password");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)
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
							e.printStackTrace();
						}
		}
	}
}
