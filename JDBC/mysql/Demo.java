import java.sql.DriverManager;
import java.sql.Connection;
class Demo
{
	public static void main(String args[])throws Exception
	{
		com.mysql.jdbc.Driver obj = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(obj);
		Connection con = null;
		con = DriverManager.getConnection("jdbc:mysql:///","root","1234");
		System.out.println(con.getClass());
		if(con == null)
		{
			System.out.println("Connection Not Established");
		}
		else
		{
			System.out.println("Connection Established");
		}
	}
}