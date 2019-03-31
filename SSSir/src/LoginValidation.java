import java.sql.*;
import java.util.Scanner;
public class LoginValidation {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter username");
		String un=sc.next();
		System.out.println("enter password");
		String pwd=sc.next();
		String qry="SELECT fullname FROM USER WHERE uid='"+un+"' AND pass='"+pwd+"'";
		String url="jdbc:mysql://localhost:3306/emp";
		try
		{
			String username="pankaj";
			String password="root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, username, password);
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(qry);
			if(rs.next())
			{
				String fullname=rs.getString("fullname");
				System.out.println("welcome "+fullname);
			}
			else
			{
				System.err.println("invalid user");
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
