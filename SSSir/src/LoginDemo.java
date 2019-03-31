import java.sql.*;
public class LoginDemo {
	String sql="SELECT uname,pass FROM login WHERE uname='+un+' AND pass='dingi'";
	String url="jdbc:mysql://localhost:3306/test";
	String username="pankaj";
	String password="root";
	public boolean check (String uname,String pass)	
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, username, password);
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pass);
			ResultSet rs=st.executeQuery(sql);
			if(rs.next())
			{
				System.out.println("Your fullname is "+uname+" "+pass);
				//return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
