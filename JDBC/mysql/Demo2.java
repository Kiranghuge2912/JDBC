import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
class Demo2
{
	public static void main(String args[])throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = null;
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kiran","root","1234");
		if(con == null)
		{
			System.out.println("Connection Not Established");
		}
		else
		{
		System.out.println("Connection Established");
		Statement st = con.createStatement();
		String Query;
		
		//Display
		Query = "SELECT* FROM STUDENTINFO";
		ResultSet rs = st.executeQuery(Query);
		while(rs.next()!=false)
		{
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
		}
		System.out.println();
		
		//Search
		System.out.println("Enter Student id to search:-");
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		Query = "SELECT* FROM studentinfo WHERE sid="+s;
		
		rs = st.executeQuery(Query);
		if(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
		}
		else
		{
			System.out.println("Recoed not Found");
		}
		
		//Insertion
		System.out.println("\nEnter Data to Insert Into Table:-");
		System.out.println("Enter Student Id:-");
		int sid = sc.nextInt();
		System.out.println("Enter Student Name:-");
		String sname = sc.next();
		System.out.println("Enter Student Percentage:-");
		float sper = sc.nextFloat();
		Query = "INSERT INTO studentinfo values("+sid+", '"+sname+"', "+sper+")";
		st.executeUpdate(Query);
		
		Query = "SELECT* FROM STUDENTINFO";
		rs = st.executeQuery(Query);
		while(rs.next()!=false)
		{
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
		}
		System.out.println();
		
		//Deletion
		System.out.println("Enter Student Id For Deletion:-");
		int sid1 = sc.nextInt();
		Query = "DELETE FROM studentinfo WHERE sid="+sid1;
		st.executeUpdate(Query);
		Query = "SELECT* FROM STUDENTINFO";
		rs = st.executeQuery(Query);
		while(rs.next()!=false)
		{
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
		}
		
		//Update
		System.out.println("Enter Student Id whose name you want to Update:-");
		sid = sc.nextInt();
		System.out.println("Enter Student Name:-");
		sname = sc.next();
		Query = "UPDATE studentinfo set sname='"+sname+"' WHERE sid="+sid;
		st.executeUpdate(Query);
		Query = "SELECT* FROM STUDENTINFO";
		rs = st.executeQuery(Query);
		while(rs.next()!=false)
		{
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
		}
		}
	}
}