import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ExecuteMethodsLopHoles {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver="sun.jdbc.oracle.jdbc.odbc.Driver";
		String url="jdbc.odbc.localhost";
		String user="scott";
		String 	pwd="tiger";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, user, pwd);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("update emp set sal=20000 where enmae=scott");
		con.close();
	}
}
