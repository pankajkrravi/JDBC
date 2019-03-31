package com.jspiders.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class MYSqlDemo {
	public static void main(String[] args) {
		final String url="jdbc:msql://localhost:3306";
		final String Driver="com.mysql.jdbc.Driver";
		Properties props=new Properties();
		FileReader reader=null;
		try{
			reader=new FileReader("config/mysql.jdbc.Driver");
		props.load(reader);
		Driver d=new com.mysql.jdbc.Driver();
		Connection con=d.connect(url, props);
		System.out.println("Connection success"+con);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(reader!=null)
			{
				try{
					reader.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
