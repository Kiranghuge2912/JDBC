import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
class LoginApp1
{
	public static void main(String args[]) throws Exception
	{
		Connection con = null;
		ResultSet Rs = null;
		Statement St = null;
		Scanner Sc = null;
		try
		{
		String query;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kiran2","root","1234");
		St = con.createStatement();
		Sc = new Scanner(System.in);
		
		System.out.println("Enter the Username:-");
		String username = Sc.nextLine();
		
		System.out.println("Enter the Password:-");
		String password = Sc.nextLine();
		
		query = "SELECT count(0) From user WHERE username='"+username+"' and password='"+password+"'";
		Rs = St.executeQuery(query);
		Rs.next();
		int count = Rs.getInt(1);
		
		if(count == 1)
		{
			System.out.println("Login Succesful !!!");
		}
		else
		{
				System.out.println("Invalide Username Or Password !!!");
		}
		}
		catch(Exception ex)
		{
			System.out.println("Catch block executed !!!\nException occur:"+ex.getClass());
		}
		finally
		{
			System.out.println("Finally block executed");
			con.close();
			Rs.close();
		    St.close();
			Sc.close();
		}
	}
	
}