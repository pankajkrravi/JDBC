package com.transactionApp;

import java.sql.*;
import java.util.Scanner;

public class TransactionSavePoint {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		String qry = "insert into jdbcdb.studentedu values(?,?,?,?)";
		String insery = "insert into jdbcdb.studentper values(?,?,?)";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id????");
		int id = sc.nextInt();
		System.out.println("Enter name???");
		String name = sc.next();
		System.out.println("Enter perc???");
		double perc = sc.nextDouble();
		System.out.println("Enter dept??");
		String dept = sc.next();
		System.out.println("Enter place???");
		String place = sc.next();
		sc.close();
		Savepoint sp = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setDouble(3, perc);
			pstmt.setString(4, dept);
			pstmt.executeUpdate();
			System.out.println("Student educational details executed");
			sp = con.setSavepoint();
			pstmt1 = con.prepareStatement(insery);
			pstmt1.setInt(1, id);
			pstmt1.setString(2, name);
			pstmt1.setString(3, place);
			pstmt1.executeUpdate();
			System.out.println("Student personal details executed");
			con.commit();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		try {
			con.rollback(sp);
			con.commit();
			System.out.println("Operation  rollback");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		}finally {
		if (pstmt1 != null)
			try {
				pstmt1.close();
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
