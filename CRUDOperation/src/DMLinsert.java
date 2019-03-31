import java.sql.*;
import java.util.Scanner;
public class DMLinsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String url="jdbc:mysql://localhost:3306/emp";
		String uname="pankaj";
		String pass="root";
		Connection con=DriverManager.getConnection(url, uname, pass);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter employee id ");
		int empid=sc.nextInt();
		System.out.println("Enter Employee name");
		String ename=sc.next();
		System.out.println("Enter Department name");
		String edept=sc.next();
		System.out.println("Enter employee Salary");
		double esal=sc.nextDouble();
		String query="INSERT INTO employee VALUES(?,?,?,?)";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1, empid);
		st.setString(2, ename);
		st.setString(3, edept);
		st.setDouble(4, esal);
		int count= st.executeUpdate();
		System.out.println(" Data  inserted succesfully");
		st.close();
		con.close();
	}
}

