import java.sql.*;
import java.util.Scanner;
public class DeleteQuery {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter film id to delete record");
		int fid=s.nextInt();
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
			String query="DELETE FROM films WHERE film_id='"+fid+"'";
			int roweffected=stmt.executeUpdate(query);
			System.out.println(roweffected+" row effected");
			System.out.println("Record deleted sucessfully");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
