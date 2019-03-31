import java.sql.*;
import java.util.Scanner;
public class UpdateDemo {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter filmid");
		int fid=sc.nextInt();
		System.out.println("Enter film title");
		String ft=sc.next();
		String url="jdbc:mysql://localhost:3306/sakila";
		String user="pankaj";
		String pwd="root";
		try
		{
			//1. create connection to db
			Connection con=DriverManager.getConnection(url, user, pwd);
			//2.create a statement
			Statement stmt=con.createStatement();
			//3. Execute query
			String query="UPDATE film SET title='"+ft+"' WHERE film_id='"+fid+"'";
			stmt.executeUpdate(query);
			System.out.println("Update sucessfully");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
