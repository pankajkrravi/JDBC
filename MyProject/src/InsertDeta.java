import java.sql.*;
import java.util.Scanner;

public class InsertDeta {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/emp";
		String user = "pankaj";
		String pwd = "root";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id");
		int id = sc.nextInt();
		System.out.println("enter emp name");
		String en = sc.next();
		System.out.println("enter deartment name");
		String dn = sc.next();
		System.out.println("enter your salary");
		int sl = sc.nextInt();
		// final String
		String qry = "INSERT INTO employee VALUES("+id+",'"+en+"','"+dn+"',"+sl+")";
		// loading and register the driver
		Class.forName("com.mysql.jdbc.Driver");
		// establish the connection
		// Connection con=DriverManager.getConnection(url2);
		Connection con = DriverManager.getConnection(url, user, pwd);
		// crate statement/ platform
		Statement stmt = con.createStatement();
		// execute
		stmt.execute(qry);
		// close te=he resources
		stmt.close();
		con.close();
		System.out.println("data inserted succesfully");

	}
}
