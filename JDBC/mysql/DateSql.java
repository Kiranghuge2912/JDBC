import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.sql.Statement;
class DateSql
{
	public static void main(String args[])throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Scanner Sc = new Scanner(System.in);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kiran", "root", "1234");
		
		String query="INSERT INTO date value(?, ?, ?)";
		ps = con.prepareStatement(query);
		
		System.out.println("Enter The Student Information::");
		System.out.println("Enter The Id:-");
		int sid = Sc.nextInt();
		System.out.println("Enter The Name:-");
		String sname = Sc.next();
		System.out.println("Enter The DateOfBirth:-");
		String sdob = Sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");	
		
		java.util.Date jdate = sdf.parse(sdob);				//converting string into java date format(parse method return type java.util.Date)
		System.out.println(jdate);
		
		long ms = jdate.getTime();    						//getTime() method returns the miliseconds
		
		java.sql.Date sdate = new java.sql.Date(ms);		//converting java date format into sql data format
		System.out.println(sdate);		
		
		ps.setInt(1,sid);
		ps.setString(2,sname);
		ps.setDate(3,sdate);
		
		int count = ps.executeUpdate();
		
		if(count == 1)
			System.out.println("Record Inserted Succesfully !!!");
		else
			System.out.println("Record Not Inserted !!!");
		
		query = "SELECT* FROM date";
		Statement St = con.createStatement();
		rs = St.executeQuery(query);
		while(rs.next() != false)
		{
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}

	}			
}