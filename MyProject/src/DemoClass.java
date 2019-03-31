import java.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DemoClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student ID");
		int nn=sc.nextInt();
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String uname = "pankaj";
		String pass = "root";
		String query = "SELECT sname  FROM student WHERE sid="+nn+"";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		String name = rs.getString("sname");
		System.out.println("Your Name is "+name);
		st.close();
		con.close();
	}

}
