import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
class LoginApp2
{
	public static void main(String args[]) throws Exception
	{
		Connection con;
		ResultSet Rs;
		PreparedStatement ps;
		
		Statement St;
		try(Scanner Sc = new Scanner(System.in))
		{
		String query;
		Class.forName("com.mysql.jdbc.Driver");
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kiran2","root","1234");
		St = con.createStatement();
		query = "SELECT count(0) From user WHERE username=? and password=?";
		ps = con.prepareStatement(query);
		System.out.println("Enter the Username:-");
		String username = Sc.nextLine();
		
		System.out.println("Enter the Password:-");
		String password = Sc.nextLine();
		ps.setString(1,username);
		ps.setString(2,password);

		
		Rs = ps.executeQuery();
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
			System.out.println("Catch block executed !!!\nException occur:");
			System.out.println(ex.toString());
		}
		//Implicityly finally block inserted and executed in case of try with resource
	}
	
}