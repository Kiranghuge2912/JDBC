import java.sql.DriverManager;
import java.sql.Connection;
class Demo
{
	public static void main(String args[])throws Exception
	{
		oracle.jdbc.driver.OracleDriver obj = new oracle.jdbc.driver.OracleDriver();
		DriverManager.registerDriver(obj);
		
		Connection Con = null;
		
		Con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","1234");
		
		System.out.println(Con.getClass().getName());
		if(Con == null)
		{
			System.out.println("Connection Not Established !!!");
		}
		else
		{
			System.out.println("Connection Established !!!");
		}
	}
}