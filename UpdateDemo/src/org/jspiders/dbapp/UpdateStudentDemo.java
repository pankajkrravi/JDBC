package org.jspiders.dbapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateStudentDemo {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter ID");
		String id=s.next();
		System.out.println("Enter parcentage");
		double per=s.nextDouble();
		s.close();
		String uquery="UPDATE jdbcdb.student SET percentage ='"+per+"' WHERE sid='"+id+"'";
		Connection con=null;
		Statement stmt=null;
		final String url="jdbc:mysql://localhost:3306?user=pankaj&password=root";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url);
			stmt=con.createStatement();
			int noru=stmt.executeUpdate(uquery);
			System.out.println(noru+" records updateed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt!=null)
				{
					stmt.close();
				}
				if(con!=null)
				{
					con.close();
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
