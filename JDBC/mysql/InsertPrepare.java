import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;
class InsertPrepare
{
	public static void main(String args[])throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Scanner Sc = new Scanner(System.in);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kiran", "root", "1234");
		
		String query="INSERT INTO studentinfo value(?, ?, ?)";
		ps = con.prepareStatement(query);
		
		System.out.println("Enter The Student Information::");
		System.out.println("Enter The Id:-");
		int sid = Sc.nextInt();
		System.out.println("Enter The Name:-");
		String sname = Sc.next();
		System.out.println("Enter The Percentage:-");
		float sper = Sc.nextFloat();
		
		ps.setInt(1,sid);
		ps.setString(2,sname);
		ps.setFloat(3,sper);
		
		int count = ps.executeUpdate();
		
		if(count == 1)
			System.out.println("Record Inserted Succesfully !!!");
		else
			System.out.println("Record Not Inserted !!!");

	}			
}