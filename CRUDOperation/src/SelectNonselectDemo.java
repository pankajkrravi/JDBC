import java.sql.*;
import java.util.Scanner;
public class SelectNonselectDemo {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
	String deiver ="oracle.jdbc.OracleDriver";
	String url="jdbc.oracle.thi:@localhost.1521";
	String usr="scott";
	String pwd="tiger";
	Class.forName(deiver);
	Connection con=DriverManager.getConnection(url);
	Statement st=con.createStatement();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the query");
	String query=sc.nextLine();
	boolean b=st.execute(query);
	if(b==true)
	{
		ResultSet rs=st.getResultSet();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
	}
	else
	{
		int rowCount=st.getUpdateCount();
		System.out.println("the no of records ueffected"+rowCount);
	}
	con.close();
}
}
