package jbpDemo;

//insert update homework
//2 database oracle// mysql
//student with 2 columns in both db
//wajp to where retrive from one table and insetr in to another table
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner ss = new Scanner(System.in);
		System.out.println("Enter id no to delete record");
		int idd = ss.nextInt();
		System.out.println("test 1");
		// Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Test 2");
		// step 2
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
		// to know db related info ex->Miner version,miner version
		DatabaseMetaData dbmt = con.getMetaData();
		System.out.println(dbmt.getDatabaseMajorVersion());
		System.out.println(dbmt.getDatabaseMinorVersion());// etc
		System.out.println("Test 3");
		// commit
		// rollback
		// this is also know an 2 phase commit protocol
		// step 3
		Statement stmt = con.createStatement();
		String sqldel = "delete from city where id=" + idd + "";
		con.setAutoCommit(false);// it will execute only if all the query will
									// get executed
		try {
			int rowsupdated = stmt.executeUpdate(sqldel);
			int rd2 = stmt.executeUpdate(sqldel);
			int rd3 = stmt.executeUpdate(sqldel);
			System.out.println(rowsupdated + " rows updated");
		} catch (Exception e) {
			con.commit();
		}
		/*
		 * String query = "select * from city"; //step 4 ResultSet res =
		 * stmt.executeQuery(query); // next()--> ResultSetMetaData rsmdt =
		 * res.getMetaData(); while (res.next()) { String col =
		 * res.getString("ID"); String col2 = res.getString("Name"); String col3
		 * = res.getString(3); System.out.println(col);
		 * System.out.println(col2); System.out.println(col3); }
		 */
	}
}
