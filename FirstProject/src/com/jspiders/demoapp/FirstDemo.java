package com.jspiders.demoapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/dinga")
public class FirstDemo extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("HII .. HELLO.....");	
		//jdbc code
		 String query="select emp.employee where empid=2";
		 try{

			 Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/emp";
				String uname="pankaj";
				String pass="root";
				String qery="SELECT  empid, ename ,esal,edept FROM employee WHERE empid=2";
				Connection con=DriverManager.getConnection(url, uname, pass);
				Statement st=con.createStatement();
				ResultSet rs= st.executeQuery(qery);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
						String htmlOutput="<html><body bgcolor='pink'>"
				+ "<h1>"
				+ "welcome to first servlet"
				+ "</h1>"
				+ "</body></html>";
		PrintWriter pw=resp.getWriter();
		pw.println(htmlOutput);
		pw.close();
	}
}

