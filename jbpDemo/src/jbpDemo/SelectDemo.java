package jbpDemo;

import java.sql.*;

public class SelectDemo {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
		Statement stmt = con.createStatement();
		String query = "select * from city";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			String col = rs.getString("ID");
			String col2 = rs.getString("Name");
			String col3 = rs.getString(3);
			System.out.println(col);
			System.out.println(col2);
			System.out.println(col3);
		}
	}
}
