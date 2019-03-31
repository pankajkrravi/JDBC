package jdbcDemp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
	public static void main(String[] args) {
	String iqry="INSERT INTO jdbcdb.student VALUES(601,'pankaj',60.23)";
		Statement st=null;
		Connection con=null;
		try {
			//step 1
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Laad rnd registred");
			//step2
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("connection established");
			//step 3==>create platform
			st=con.createStatement();
			System.out.println("platfrom is created");
			st.executeUpdate(iqry);
			System.out.println("Data is insserted");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
