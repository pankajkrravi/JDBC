import java.sql.*;
import java.util.Scanner;
public class DQLSelcetDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		System.out.println("enter employee id");
		int eid=s.nextInt();
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/emp";
		String uname="pankaj";
		String pass="root";
		String query="SELECT  empid, ename ,esal,edept FROM employee WHERE empid='"+eid+"'";
		Connection con=DriverManager.getConnection(url, uname, pass);
		Statement st=con.createStatement();
		ResultSet rs= st.executeQuery(query);
		rs.next();
		String name=rs.getString("ename");
		String sal=rs.getString("esal");
		String id=rs.getString("empid");
		String dept=rs.getString("edept");
		System.out.println();
		System.out.println("your Employeid "+ id  +" name is " +name+"  And Salary is  "+sal+""+"  department  "+dept);
		st.close();
		con.close();
	}
}
