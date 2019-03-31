import java.sql.*;
import java.util.Scanner;
public class DQLUsingloop {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");//class for name telesko
		String url="jdbc:mysql://localhost:3306/emp";
		String uname="pankaj";
		String pass="root";
		String query="SELECT * FROM employee";
		Connection con=DriverManager.getConnection(url, uname, pass);
		Statement st=con.createStatement();
		ResultSet rs= st.executeQuery(query);
		while(rs.next())
		{
			String userdata=rs.getInt(1)+"   "+rs.getString(2)+"    "+rs.getDouble(4)+"   "+rs.getString(3);
			System.out.println(userdata);
			System.out.println();
		}
		st.close();
		con.close();
	}
}


