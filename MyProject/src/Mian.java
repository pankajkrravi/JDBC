import java.sql.Connection;
import java.sql.DriverManager;

public class Mian {
	public static void main(String[] args) throws Exception {
		getconnection();
	}
	public static Connection getconnection() throws Exception{
		try
		{
			String driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306";
			String username="pankaj";
			String password="root";
			Class.forName(driver);
			
			Connection con=DriverManager.getConnection(url, username, password);
			System.out.println("conncted");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
}
