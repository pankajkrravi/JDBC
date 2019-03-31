import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class DelecteProductDemo {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter product id to delete record");
		int pd=sc.nextInt();
		String delqry="DELETE FROM jdbcdb.product  WHERE pid='"+pd+"'";
		Connection con=null;
		Statement stmt=null;
		final String url="jdbc:mysql://localhost:3306?user=pankaj&password=root";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url);
			stmt=con.createStatement();
			int nora=stmt.executeUpdate(delqry);
			System.out.println(nora+" no of rows deleted");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt!=null)
				{
					stmt.close();
				}
				if(con!=null)
				{
					con.close();
				}	
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
	}
}
}

