import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class SearchStudents {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter student id");
		int sid=sc.nextInt();
		String dqlqry="SELECT * FROM studentdb.student WHERE sid="+sid+"";
		String DRIVER="com.mysql.jdbc.Driver";
		String URL="jdbc:mysql://localhost:3306";
		try
		{
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL, "pankaj", "root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(dqlqry);
			if(rs.next())
			{
				int id=rs.getInt("sid");
				String sname=rs.getString(2);
				String stream=rs.getString(3);
				String college=rs.getString(4);
				System.out.println(sid+"  "+sname+"  "+stream+ "   "+college);
			}
			else
			{
				System.out.println("no data found");
			}
			rs.close();
		}
		catch( Exception e)
		{
			e.printStackTrace();

		}
	}
}


