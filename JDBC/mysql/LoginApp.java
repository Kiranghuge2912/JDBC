import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
class LoginApp
{
	public static void main(String args[])
	{
		String query;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		ResultSet Rs = null;
		Statement St = con.createStatement();
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kiran2","root","1234");
		Scanner Sc = new Scanner(System.in);
		
		System.out.println("Enter the Username:-")
		String username = Sc.nextLine();
		
		System.out.println("Enter the Password:-")
		String password = Sc.nextLine();
		
		query = "SELECT count(0) From user WHERE username='"+username+"' and password='"+password"'";
		Rs = St.executeQuery(query);
		
		int count = 0;
		while(Rs.next())
		{
			count = Rs.getInt(1);
			
			if(count > 0)
			{
				System.out.println("Login Succesful !!!");
			}
			else
			{
				System.out.println("Invalide Username Or Password !!!");
			}
	}
	
}